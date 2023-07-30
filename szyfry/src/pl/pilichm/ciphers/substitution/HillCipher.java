package pl.pilichm.ciphers.substitution;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;
import pl.pilichm.util.Utils;

import java.util.ArrayList;

public class HillCipher extends AbstractCipher implements Cipher {
    private double [][] key;

    public void setKey(double[][] key) {
        this.key = key;
    }

    public double[][] getKey() {
        return key;
    }

    /**
     * Encode or decode text with Hill cipher.
     * @param textIn -> text for encoding or decoding.
     * @param encode -> if set to true then encrypt passed text. If set to false decrypt passed text.
     * @return -> encoded or decoded text.
     */
    private String processText(String textIn, boolean encode) {
        StringBuilder processedText = new StringBuilder();
        textIn = textIn.toUpperCase();

        if (key==null){
            return processedText.toString();
        }

        ArrayList<Double> splitTextIn = convertTextToDoubleArray(textIn);
        double [][] encodingDecodingMatrix = key;

        if (!encode) {
            encodingDecodingMatrix = Utils.calcInvertedModuloMatrix(key, getAlphabet().size());
        }

        for (int index=0; index<splitTextIn.size(); index+=3){
            double [] currentText = {splitTextIn.get(index), splitTextIn.get(index+1), splitTextIn.get(index+2)};

            for (int innerIndex=0; innerIndex<3; innerIndex++){
                processedText.append(getValueForRow(currentText, encodingDecodingMatrix, innerIndex));
            }
        }

        return processedText.toString();
    }

    /**
     * Converts text passed as String to array of doubles, each double represents one character.
     * @param textIn -> text for conversion.
     * @return -> array of doubles, each double represents one letter. Value of letter is taken as letter position in alphabet.
     */
    private ArrayList<Double> convertTextToDoubleArray(String textIn){
        ArrayList<Double> splitMessage = new ArrayList<>();
        ArrayList<Character> alphabet = getAlphabet();

        for (Character letter : textIn.toCharArray()){
            if (letter != ' ' && !nonLetterCharacters.contains(letter)) {
                splitMessage.add((double) alphabet.indexOf(letter));
            }
        }

        // Pad message to multiple of 3.
        while (splitMessage.size()%3!=0){
            splitMessage.add(0d);
        }

        return splitMessage;
    }

    /**
     * Calculate encrypted or decrypted value for three letter fragment of text.
     * @param message -> letter for processing. Must be represented by three doubles.
     * @param encryptionDecryptionMatrix -> key matrix for encryption or modulo inverted key matrix for decryption.
     * @param position -> Number of row of key matrix for processing.
     * @return -> double value for encrypted/decrypted letter.
     */
    private Character getValueForRow(double [] message, double [][] encryptionDecryptionMatrix, int position){
        double encodedValue = 0;
        ArrayList<Character> alphabet = getAlphabet();

        for (int index=0; index<3; index++){
            encodedValue += message[index] * encryptionDecryptionMatrix[position][index];
        }

        if (encodedValue>alphabet.size()){
            encodedValue = encodedValue%alphabet.size();
        }

        if (encodedValue < 0) {
            encodedValue += alphabet.size();
        }

        return alphabet.get((int) encodedValue);
    }

    /**
     * Decode text with Hill cipher.
     * @param textToDecode -> String with text for decoding with Hill cipher.
     * @return -> message decoded with Hill cipher and set key.
     */
    @Override
    public String decode(String textToDecode){
        return processText(textToDecode, false);
    }

    /**
     * Encode text with Hill cipher.
     * @param textToEncode -> String with text for encoding with Hill cipher.
     * @return -> message encoded with Hill cipher with set key.
     */
    @Override
    public String encode(String textToEncode) {
        return processText(textToEncode, true);
    }
}
