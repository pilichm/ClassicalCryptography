package pl.pilichm.main;

import pl.pilichm.ciphers.substitution.CaesarCipher;
import pl.pilichm.ciphers.substitution.ROT13Cipher;
import pl.pilichm.util.SupportedLanguages;

public class Main {
    public static void main(String[] args) {
        System.out.println("main() - start.");

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

        System.out.println("\nmain() - end.");
        }
}