package pl.pilichm.ciphers.substitution;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;
import pl.pilichm.util.Constants;
import pl.pilichm.util.SupportedLanguages;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;

public class AffineCipher extends AbstractCipher implements Cipher {
    private int parameter_a;
    private int parameter_b;

    public AffineCipher(int parameter_a, int parameter_b, SupportedLanguages chosenLanguage) {
        this.parameter_a = parameter_a;
        this.parameter_b = parameter_b;
        this.chosenLanguage = chosenLanguage;
        this.nonLetterCharacters = new ArrayList<>(Constants.nonLetterCharacters);
    }

    public AffineCipher() {
        parameter_a = 5;
        parameter_b = 8;
        chosenLanguage = SupportedLanguages.ENGLISH;
        nonLetterCharacters = new ArrayList<>(Constants.nonLetterCharacters);
    }

    private int getModularMultiplicativeInverse() {
        int currentNumber = 1;
        int alphabetSize = getAlphabet().size();

        while (currentNumber < alphabetSize) {
            if ((parameter_a * currentNumber) % alphabetSize == 1) {
                return currentNumber;
            } else {
                currentNumber ++;
            }
        }

        return currentNumber;
    }
    @Override
    public String decode(String textToDecode) {
        StringBuilder decodedText = new StringBuilder();
        textToDecode = textToDecode.toUpperCase();
        CharacterIterator it = new StringCharacterIterator(textToDecode);
        ArrayList<Character> alphabet = getAlphabet();
        int inverseA = getModularMultiplicativeInverse();

        while (it.current() != CharacterIterator.DONE) {
            if (alphabet.contains(it.current())) {
                int currentLetterIdx = alphabet.indexOf(it.current());
                currentLetterIdx = inverseA * (currentLetterIdx - parameter_b) % alphabet.size();

                if (currentLetterIdx < 0) {
                    currentLetterIdx += alphabet.size();
                }

                decodedText.append(alphabet.get(currentLetterIdx));
            } else if (nonLetterCharacters.contains(it.current()) || it.current() == ' '){
                decodedText.append(it.current());
            }

            it.next();
        }

        return decodedText.toString();
    }

    @Override
    public String encode(String textToEncode) {
        StringBuilder encodedText = new StringBuilder();
        textToEncode = textToEncode.toUpperCase();
        CharacterIterator it = new StringCharacterIterator(textToEncode);
        ArrayList<Character> alphabet = getAlphabet();

        while (it.current() != CharacterIterator.DONE) {
            if (alphabet.contains(it.current())) {
                int currentLetterIdx = alphabet.indexOf(it.current());
                currentLetterIdx = (parameter_a * currentLetterIdx + parameter_b) % alphabet.size();
                encodedText.append(alphabet.get(currentLetterIdx));
            } else if (nonLetterCharacters.contains(it.current()) || it.current() == ' '){
                encodedText.append(it.current());
            }
            it.next();
        }

        return encodedText.toString();
    }
}
