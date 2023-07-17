package pl.pilichm.main;

import pl.pilichm.ciphers.substitution.CaesarCipher;
import pl.pilichm.util.SupportedLanguages;

public class Main {
    public static void main(String[] args) {
        System.out.println("main() - start.");

        System.out.println("\nTest Caesar cipher on english text.");
        String plainText = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        CaesarCipher cc = new CaesarCipher(SupportedLanguages.ENGLISH);
        String encodedText = cc.encode(plainText);
        System.out.println("Encoded text: " + encodedText);
        String decodedText = cc.decode(encodedText);
        System.out.println("Decoded text: " + decodedText);

        System.out.println("\nTest Caesar cipher on polish text.");
        cc.setChosenLanguage(SupportedLanguages.POLISH);
        plainText = "Litwo! Ojczyzno moja, ty jesteś jak zdrowie";
        encodedText = cc.encode(plainText);
        System.out.println("Encoded text: " + encodedText);
        decodedText = cc.decode(encodedText);
        System.out.println("Decoded text: " + decodedText);

        System.out.println("\nmain() - end.");
        }
}