package pl.pilichm.ciphers.substitution;

import static org.junit.jupiter.api.Assertions.*;

class AffineCipherTest {
    private final String plainText = "AFFINE CIPHER";
    private final String encodedText = "IHHWVC SWFRCP";

    @org.junit.jupiter.api.Test
    void encode() {
        AffineCipher ac = new AffineCipher();
        assertEquals(ac.encode(plainText), encodedText);
    }

    @org.junit.jupiter.api.Test
    void decode() {
        AffineCipher ac = new AffineCipher();
        assertEquals(ac.decode(encodedText), plainText);
    }
}