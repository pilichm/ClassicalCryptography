package pl.pilichm.ciphers.square;

import pl.pilichm.ciphers.Cipher;

public class TwoSquareCipher extends AbstractSquareCipher implements Cipher {
    private Character [][] key = {
            new Character[]{'E', 'X', 'A', 'M', 'P'},
            new Character[]{'L', 'B', 'C', 'D', 'F'},
            new Character[]{'G', 'H', 'I', 'J', 'K'},
            new Character[]{'N', 'O', 'R', 'S', 'T'},
            new Character[]{'U', 'V', 'W', 'Y', 'Z'},
            new Character[]{'K', 'E', 'Y', 'W', 'O'},
            new Character[]{'R', 'D', 'A', 'B', 'C'},
            new Character[]{'F', 'G', 'H', 'I', 'J'},
            new Character[]{'L', 'M', 'N', 'P', 'S'},
            new Character[]{'T', 'U', 'V', 'X', 'Z'}
    };

}
