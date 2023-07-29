package pl.pilichm.ciphers.substitution;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;

import java.util.ArrayList;

public class HillCipher extends AbstractCipher implements Cipher {
    private double [][] key;

    public void setKey(double[][] key) {
        this.key = key;
    }

    public double[][] getKey() {
        return key;
    }

    @Override
    public String encode(String textToEncode) {
        StringBuilder encodedText = new StringBuilder();
        textToEncode = textToEncode.toUpperCase();

        if (key==null){
            return encodedText.toString();
        }

        ArrayList<Double> splitTextIn = convertTextToDoubleArray(textToEncode);

        for (int index=0; index<splitTextIn.size(); index+=3){
            double [] currentText = {splitTextIn.get(index), splitTextIn.get(index+1), splitTextIn.get(index+2)};

            for (int innerIndex=0; innerIndex<3; innerIndex++){
                encodedText.append(getValueForRow(currentText, innerIndex));
            }
        }

        return encodedText.toString();
    }

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

    private Character getValueForRow(double [] message, int position){
        double encodedValue = 0;
        ArrayList<Character> alphabet = getAlphabet();

        for (int index=0; index<3; index++){
            encodedValue += message[index] * key[position][index];
        }

        if (encodedValue>alphabet.size()){
            encodedValue = encodedValue%alphabet.size();
        }

        return alphabet.get((int) encodedValue);
    }

}
