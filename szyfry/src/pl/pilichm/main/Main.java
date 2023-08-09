package pl.pilichm.main;

import pl.pilichm.ciphers.square.PlayfairCipher;
import pl.pilichm.ciphers.substitution.*;
import pl.pilichm.ciphers.transposition.ColumnarTranspositionCipher;
import pl.pilichm.ciphers.transposition.RailFenceCipher;
import pl.pilichm.util.Utils;

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
//
//        double [][] key = {
//                new double[]{6, 24, 1},
//                new double[]{13, 16, 10},
//                new double[]{20, 17, 15}
//        };
//
//        String plainText = "CAT";
//        HillCipher hc = new HillCipher();
//        hc.setKey(key);
//        String encodedText = hc.encode(plainText);
//        System.out.println(encodedText);
//        String decodedText = hc.decode(encodedText);
//        System.out.println(decodedText);

//        RailFenceCipher rfc = new RailFenceCipher();
//        rfc.setKey(4);
//        String plainText = "WE ARE DISCOVERED. RUN AT ONCE.";
//        String encodedText = rfc.encode(plainText);
//        System.out.println(encodedText);
//        String decodedText = rfc.decode(encodedText);
//        System.out.println(decodedText);

        PlayfairCipher pc = new PlayfairCipher();
        //pc.test();
        String plainText = "hide the gold in the tree stump";
        String encodedText = pc.encode(plainText);
        System.out.println(encodedText);
    }
}