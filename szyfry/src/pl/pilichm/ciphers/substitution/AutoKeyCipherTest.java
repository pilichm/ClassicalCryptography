package pl.pilichm.ciphers.substitution;

import static org.junit.jupiter.api.Assertions.*;

class AutoKeyCipherTest {
    private final String plainText = "MEETATTHEFOUNTAIN";
    private final String encodedText = "WMPMMXXAEYHBRYOCA";

    private final String key = "KILT";

    @org.junit.jupiter.api.Test
    void encode() {
        AutoKeyCipher akc = new AutoKeyCipher(key);
        assertEquals(akc.encode(plainText), encodedText);
    }

    @org.junit.jupiter.api.Test
    void decode() {
        AutoKeyCipher akc = new AutoKeyCipher(key);
        assertEquals(akc.decode(encodedText), plainText);
    }
}