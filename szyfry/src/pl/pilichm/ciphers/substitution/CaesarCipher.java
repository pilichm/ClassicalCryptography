package pl.pilichm.ciphers.substitution;

import pl.pilichm.ciphers.Cipher;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class CaesarCipher implements Cipher {
    private final ArrayList<Character> alphabet = new ArrayList<>(List.of(
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    ));
    private final int caesarOffset = 23;

    @Override
    public String encode(String textToEncode) {
        return encode(textToEncode, caesarOffset);
    }

    public String encode(String textToEncode, int offset) {
        StringBuilder encodedText = new StringBuilder();
        textToEncode = textToEncode.toUpperCase();
        CharacterIterator it = new StringCharacterIterator(textToEncode);

        while (it.current() != CharacterIterator.DONE) {
            if (it.current() != ' ') {
                int currentLetterIdx = alphabet.indexOf(it.current());
                currentLetterIdx = (currentLetterIdx + offset)%alphabet.size();
                encodedText.append(alphabet.get(currentLetterIdx));
            } else {
                encodedText.append(' ');
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

        while (it.current() != CharacterIterator.DONE){
            if (it.current() != ' ') {
                int currentLetterIdx = alphabet.indexOf(it.current());
                currentLetterIdx = (currentLetterIdx - offset)%alphabet.size();

                if (currentLetterIdx < 0) {
                    currentLetterIdx += alphabet.size();
                }

                decodedText.append(alphabet.get(currentLetterIdx));
            } else {
                decodedText.append(' ');
            }

            it.next();
        }

        return decodedText.toString();
    }
}
