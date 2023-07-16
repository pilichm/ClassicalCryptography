package pl.pilichm.main;

import pl.pilichm.ciphers.substitution.CaesarCipher;

public class Main {
    public static void main(String[] args) {
        System.out.println("main() - start.");

        String plainText = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";

        CaesarCipher cc = new CaesarCipher();
        String encodedText = cc.encode(plainText);
        System.out.println("Encoded text: " + encodedText);
        String decodedText = cc.decode(encodedText);
        System.out.println("Decoded text: " + decodedText);

        System.out.println("main() - end.");
        }
}