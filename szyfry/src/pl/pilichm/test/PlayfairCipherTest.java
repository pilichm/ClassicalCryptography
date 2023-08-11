package pl.pilichm.test;

import pl.pilichm.ciphers.square.PlayfairCipher;
import static org.junit.jupiter.api.Assertions.*;

public class PlayfairCipherTest {

    @org.junit.jupiter.api.Test
    public void encode() {
        PlayfairCipher pc = new PlayfairCipher();
        String plainText = "hide the gold in the tree stump";
        String correctEncodedText = "BMDEZBXDNABEKUDMUIXEMOUTIF";
        assertEquals(pc.encode(plainText), correctEncodedText);
    }

    @org.junit.jupiter.api.Test
    public void decode() {
        PlayfairCipher pc = new PlayfairCipher();
        String encodedText = "BMDEZBXDNABEKUDMUIXEMOUTIF";
        String correctDecodedText = "HIDETHEGOLDINTHETREXESTUMP";
        assertEquals(pc.encode(encodedText), correctDecodedText);
    }
}