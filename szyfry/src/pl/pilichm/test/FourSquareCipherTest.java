package pl.pilichm.test;

import pl.pilichm.ciphers.square.FourSquareCipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourSquareCipherTest {

    @org.junit.jupiter.api.Test
    public void encode(){
        FourSquareCipher fsc = new FourSquareCipher();
        String plainText = "Help me Obi-Wan Kenobi";
        String correctEncodedText = "FY GM KY HO BX MF KK KI MD";
        assertEquals(fsc.encode(plainText), correctEncodedText);
    }

    @org.junit.jupiter.api.Test
    public void decode() {
        FourSquareCipher fsc = new FourSquareCipher();
        String encodedText = "FY GM KY HO BX MF KK KI MD";
        String correctDecodedText = "HE LP ME OB IW AN KE NO BI";
        assertEquals(fsc.decode(encodedText), correctDecodedText);
    }
}