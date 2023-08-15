package pl.pilichm.test;

import pl.pilichm.ciphers.square.TwoSquareCipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSquareCipherTest {

    @org.junit.jupiter.api.Test
    public void encode() {
        TwoSquareCipher tsc = new TwoSquareCipher();
        String plainText = "Help me Obi-Wan Kenobi";
        String correctEncodedText = "HE DL XW SD JY AN HO TK DG";
        assertEquals(tsc.encode(plainText), correctEncodedText);
    }

    @org.junit.jupiter.api.Test
    public void decode() {
        TwoSquareCipher tsc = new TwoSquareCipher();
        String encodedText = "HE DL XW SD JY AN HO TK DG";
        String correctDecodedText = "HE LP ME OB IW AN KE NO BI";
        assertEquals(tsc.decode(encodedText), correctDecodedText);
    }
}