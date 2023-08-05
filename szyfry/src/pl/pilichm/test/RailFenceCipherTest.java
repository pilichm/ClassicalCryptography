package pl.pilichm.test;

import pl.pilichm.ciphers.transposition.RailFenceCipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RailFenceCipherTest {

    @org.junit.jupiter.api.Test
    void encode() {
        String plainText = "WE ARE DISCOVERED. RUN AT ONCE.";
        String correctEncryptedText = "WECRUO ERDSOEERNTNE AIVDAC";
        RailFenceCipher rfc = new RailFenceCipher();
        rfc.setKey(3);

        assertEquals(rfc.encode(plainText), correctEncryptedText);
    }
}