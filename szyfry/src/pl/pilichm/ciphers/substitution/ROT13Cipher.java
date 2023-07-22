package pl.pilichm.ciphers.substitution;

import pl.pilichm.util.Constants;
import pl.pilichm.util.SupportedLanguages;

public class ROT13Cipher extends CaesarCipher{
    public ROT13Cipher() {
        super();
        setOffset(Constants.rot13Offset);
    }
}
