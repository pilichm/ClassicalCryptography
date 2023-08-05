package pl.pilichm.ciphers.transposition;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;

public class RailFenceCipher extends AbstractCipher implements Cipher {
    private int key;

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String encode(String textToEncode) {
        StringBuilder processedText = new StringBuilder();
        textToEncode = textToEncode.toUpperCase();

        if (key<=0)
            return processedText.toString();

        for (Character character : nonLetterCharacters){
            textToEncode = textToEncode.replace(character.toString(), "");
        }

        textToEncode = textToEncode.replace(" ", "");

        int numberOfColumns = textToEncode.length();
        int numberOfRows = key;

        System.out.println("Rows: " + numberOfRows + " cols: " + numberOfColumns);

        Character [][] encodingTable = new Character[numberOfRows][numberOfColumns];
        for (int rowIdx=0; rowIdx<numberOfRows; rowIdx++){
            for (int colIdx=0; colIdx< numberOfColumns; colIdx++){
                encodingTable[rowIdx][colIdx] = '.';
            }
        }

        int rowCounter = 0;
        int colCounter = 0;
        boolean isAscending = true;

        for (Character c: textToEncode.toCharArray()){
            encodingTable[rowCounter][colCounter] = c;

            if (rowCounter==(numberOfRows-1)){
                isAscending = false;
            } else if (rowCounter==0) {
                isAscending = true;
            }

            if (isAscending){
                rowCounter++;
            } else {
                rowCounter--;
            }

            colCounter++;
        }

        for (int rowIdx=0; rowIdx<numberOfRows; rowIdx++){
            for (int colIdx=0; colIdx< numberOfColumns; colIdx++){
                System.out.print(encodingTable[rowIdx][colIdx] + " ");
                if (encodingTable[rowIdx][colIdx]!='.'){
                    processedText.append(encodingTable[rowIdx][colIdx]);
                }
            }
            System.out.println();
            processedText.append(" ");
        }

        return processedText.toString().trim();
    }
}
