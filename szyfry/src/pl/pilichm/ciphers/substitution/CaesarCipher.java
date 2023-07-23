package pl.pilichm.ciphers.substitution;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;
import pl.pilichm.util.Constants;

public class CaesarCipher extends AbstractCipher implements Cipher {
    private int offset;

    public CaesarCipher() {
        super();

        this.offset = Constants.caesarOffset;
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
