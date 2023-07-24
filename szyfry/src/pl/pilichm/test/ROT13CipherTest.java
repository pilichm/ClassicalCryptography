package pl.pilichm.test;

import pl.pilichm.ciphers.substitution.ROT13Cipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ROT13CipherTest {
    private final String plainText = "";
    private final String encodedText = "";

    @org.junit.jupiter.api.Test
    void encode() {
        ROT13Cipher rot3 = new ROT13Cipher();
        assertEquals(rot3.encode(plainText), encodedText);
    }

    @org.junit.jupiter.api.Test
    void decode() {
        ROT13Cipher rot3 = new ROT13Cipher();
        assertEquals(rot3.decode(encodedText), plainText);
    }

}