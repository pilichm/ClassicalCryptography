package pl.pilichm.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.pilichm.ciphers.transposition.ColumnarTranspositionCipher;

import static org.junit.jupiter.api.Assertions.*;

class ColumnarTranspositionCipherTest {

    @org.junit.jupiter.api.Test
    void decode() {
        ColumnarTranspositionCipher ctc = new ColumnarTranspositionCipher();
        ctc.setKey("ZEBRAS");
        String plaintext = "WE ARE DISCOVERED. FLEE AT ONCE.";
        String encodedText = ctc.encode(plaintext);
        System.out.println(encodedText);
        String decodedText = ctc.decode(encodedText);

        assertTrue(decodedText.contains("WEAREDISCOVEREDFLEEATONCE"));
    }
}