package pl.pilichm.main;

import pl.pilichm.ciphers.substitution.AffineCipher;
import pl.pilichm.ciphers.substitution.AutoKeyCipher;
import pl.pilichm.ciphers.substitution.CaesarCipher;
import pl.pilichm.ciphers.substitution.ROT13Cipher;
import pl.pilichm.util.SupportedLanguages;
import pl.pilichm.util.Utils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("main() - start.");

        /*
        CaesarCipher cc = new CaesarCipher(SupportedLanguages.ENGLISH);

        cc.setChosenLanguage(SupportedLanguages.ENGLISH);
        cc.encodeFile("/Users/michalpilichowski/Desktop/migration/test_file_1.txt",
                "/Users/michalpilichowski/Desktop/migration/encoded_file_1.txt");
        cc.decodeFile("/Users/michalpilichowski/Desktop/migration/encoded_file_1.txt",
                "/Users/michalpilichowski/Desktop/migration/decoded_file_1.txt");

        ROT13Cipher rot13 = new ROT13Cipher();
        String plainText = "Why did the chicken cross the road?";
        String encodedText = rot13.encode(plainText);
        System.out.println("Encoded text: " + encodedText);
        String decodedText = rot13.decode(encodedText);
        System.out.println("Decoded text: " + decodedText);
        */
        /*
        AffineCipher ac = new AffineCipher();
        String plainText = "AFFINE CIPHER";
        String encodedText = ac.encode(plainText);
        System.out.println("Encoded text: " + encodedText);
        String decodedText = ac.decode(encodedText);
        System.out.println("Decoded text: " + decodedText);
        */
        /*
        AutoKeyCipher akc = new AutoKeyCipher("KILT");
        String plainText = "meet at the fountain";
        String encodedText = akc.encode(plainText);
        System.out.println(encodedText);
        String decodedText = akc.decode(encodedText);
        System.out.println("Decoded text: " + decodedText);

         */

        double[][] matrix = {
                new double[]{2, -3, 1},
                new double[]{2, 0, -1},
                new double[]{1, 4, 5}
        };

        double determinant = Utils.calcDeterminantForThreeThreeMatrix(matrix);
        System.out.println(determinant);

        System.out.println("\nmain() - end.");
    }
}