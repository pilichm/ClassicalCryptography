package pl.pilichm.ciphers.substitution;

import pl.pilichm.ciphers.Cipher;
import pl.pilichm.util.Constants;
import pl.pilichm.util.SupportedLanguages;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class CaesarCipher implements Cipher {
    private SupportedLanguages chosenLanguage;
    private ArrayList<Character> nonLetterCharacters;

    public CaesarCipher(SupportedLanguages chosenLanguage) {
        this.chosenLanguage = chosenLanguage;
        this.nonLetterCharacters = new ArrayList<>(Constants.nonLetterCharacters);
    }

    public void setChosenLanguage(SupportedLanguages chosenLanguage) {
        this.chosenLanguage = chosenLanguage;
    }

    public SupportedLanguages getChosenLanguage() {
        return chosenLanguage;
    }

    private final int caesarOffset = 23;

    @Override
    public String encode(String textToEncode) {
        return encode(textToEncode, caesarOffset);
    }

    public String encode(String textToEncode, int offset) {
        StringBuilder encodedText = new StringBuilder();
        textToEncode = textToEncode.toUpperCase();
        CharacterIterator it = new StringCharacterIterator(textToEncode);
        ArrayList<Character> alphabet = getAlphabet();

        while (it.current() != CharacterIterator.DONE) {
            if (alphabet.contains(it.current())) {
                int currentLetterIdx = alphabet.indexOf(it.current());
                currentLetterIdx = (currentLetterIdx + offset)%alphabet.size();
                encodedText.append(alphabet.get(currentLetterIdx));
            } else if (nonLetterCharacters.contains(it.current()) || it.current() == ' '){
                encodedText.append(it.current());
            }
            it.next();
        }

        return encodedText.toString();
    }

    @Override
    public String decode(String textToDecode) {
        return decode(textToDecode, caesarOffset);
    }

    public String decode(String textToDecode, int offset){
        StringBuilder decodedText = new StringBuilder();
        textToDecode = textToDecode.toUpperCase();
        CharacterIterator it = new StringCharacterIterator(textToDecode);
        ArrayList<Character> alphabet = getAlphabet();

        while (it.current() != CharacterIterator.DONE){
            if (alphabet.contains(it.current())) {
                int currentLetterIdx = alphabet.indexOf(it.current());
                currentLetterIdx = (currentLetterIdx - offset)%alphabet.size();

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

    private ArrayList<Character> getAlphabet(){
        switch (getChosenLanguage()){
            case POLISH -> {
                return new ArrayList<>(Constants.alphabetPolish);
            }
            default -> {
                return new ArrayList<>(Constants.alphabetEnglish);
            }
        }
    }
}
