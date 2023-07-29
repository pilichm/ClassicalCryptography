package pl.pilichm.test;

import org.junit.jupiter.api.Test;
import pl.pilichm.ciphers.substitution.HillCipher;

import static org.junit.jupiter.api.Assertions.*;

class HillCipherTest {

    @org.junit.jupiter.api.Test
    void setKey() {
        double [][] key = {
                new double[]{6, 24, 1},
                new double[]{13, 16, 10},
                new double[]{20, 17, 15}
        };

        HillCipher hc = new HillCipher();
        hc.setKey(key);

        assertArrayEquals(hc.getKey(), key);
    }

    @org.junit.jupiter.api.Test
    void encode() {
        double [][] key = {
                new double[]{6, 24, 1},
                new double[]{13, 16, 10},
                new double[]{20, 17, 15}
        };

        HillCipher hc = new HillCipher();
        hc.setKey(key);

        String plainText = "CAT";
        String correctEncodedMessage = "FIN";

        assertEquals(hc.encode(plainText), correctEncodedMessage);
    }
}