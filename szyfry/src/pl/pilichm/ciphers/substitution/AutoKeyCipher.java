package pl.pilichm.ciphers.substitution;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;
import pl.pilichm.util.Utils;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;

public class AutoKeyCipher extends AbstractCipher implements Cipher {
    private String primer;

    public AutoKeyCipher(String primer) {
        super();
        this.primer = primer;
    }

    public void setPrimer(String primer) {
        this.primer = primer;
    }

    public String getPrimer() {
        return primer;
    }

    @Override
    public String decode(String textToDecode) {
        StringBuilder decodedText = new StringBuilder();
        textToDecode = textToDecode.toUpperCase();
        CharacterIterator it = new StringCharacterIterator(textToDecode);
        ArrayList<Character> alphabet = getAlphabet();

        Character [][] tabulaRecta = Utils.getTabulaRectaForLanguage(getChosenLanguage());
        ArrayList<Character> decryption = new ArrayList<>();
        for (Character character : primer.toCharArray()) {
            decryption.add(character);
        }

        int index = 0;
        while (it.current() != CharacterIterator.DONE){
            int currentKeyIndex = alphabet.indexOf(decryption.get(index));

            int letterPosition = 0;

            while (tabulaRecta[currentKeyIndex][letterPosition] != it.current()) {
                letterPosition++;
            }

            Character decodedLetter = tabulaRecta[0][letterPosition];

            decodedText.append(decodedLetter);
            decryption.add(decodedLetter);

            index++;
            it.next();
        }

        return decodedText.toString();
    }

    @Override
    public String encode(String textToEncode) {
        StringBuilder encodedText = new StringBuilder();
        ArrayList<Character> alphabet = getAlphabet();

        textToEncode = textToEncode.toUpperCase();
        for (Character nonLetterChar : nonLetterCharacters){
            textToEncode = textToEncode.replace(nonLetterChar.toString(), "");
        }
        textToEncode = textToEncode.replace(" ", "");

        CharacterIterator it = new StringCharacterIterator(textToEncode);

        String key = primer + textToEncode;
        CharacterIterator keyIt = new StringCharacterIterator(key);
        Character [][] tabulaRecta = Utils.getTabulaRectaForLanguage(getChosenLanguage());

        while (it.current() != CharacterIterator.DONE) {
            int currentLetterIdx = alphabet.indexOf(it.current());
            int currentKeyIndex = alphabet.indexOf(keyIt.current());

            Character encodedLetter = tabulaRecta[currentLetterIdx][currentKeyIndex];
            encodedText.append(encodedLetter);

            it.next();
            keyIt.next();
        }

        return encodedText.toString();
    }
}
