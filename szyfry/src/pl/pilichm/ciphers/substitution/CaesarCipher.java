package pl.pilichm.ciphers.substitution;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;
import pl.pilichm.util.Constants;
import pl.pilichm.util.SupportedLanguages;

import java.util.ArrayList;

public class CaesarCipher extends AbstractCipher implements Cipher {
    private int offset;

    public CaesarCipher() {
        this.nonLetterCharacters = new ArrayList<>(Constants.nonLetterCharacters);
        this.offset = Constants.caesarOffset;
        this.setChosenLanguage(SupportedLanguages.ENGLISH);
        this.encodingFunction = currentLetterIdx -> (currentLetterIdx + offset)%getAlphabet().size();
        this.decodingFunction = currentLetterIdx -> (currentLetterIdx - offset)%getAlphabet().size();
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
