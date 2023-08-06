package pl.pilichm.ciphers.transposition;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

        int repeatNumber = 2 * (key - 1);

        StringBuilder sb = new StringBuilder(textToEncode);
        while (textToEncode.length()%repeatNumber!=0){
            sb.append('A');
        }
        textToEncode = sb.toString();

        int numberOfColumns = textToEncode.length();
        int numberOfRows = key;

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

    @Override
    public String decode(String textToDecode) {
        StringBuilder processedText = new StringBuilder();

        if (key<=0)
            return processedText.toString();

        String [] splitEncodedText = textToDecode.split(" ");

        ArrayList<String> rightElements = new ArrayList<>();
        ArrayList<String> leftElements = new ArrayList<>();

        for (String element : splitEncodedText){
            if (element.length()>splitEncodedText[0].length()){
                StringBuilder evenElement = new StringBuilder();
                StringBuilder oddElement = new StringBuilder();

                for (int elementIdx=0; elementIdx<element.length(); elementIdx++){
                    if (elementIdx%2==0){
                        evenElement.append(element.toCharArray()[elementIdx]);
                    } else {
                        oddElement.append(element.toCharArray()[elementIdx]);
                    }
                }
                rightElements.add(evenElement.toString());
                leftElements.add(oddElement.toString());
            } else {
                rightElements.add(element);
            }
        }

        Collections.reverse(leftElements);
        for (String text: rightElements){
            System.out.println(text);
        }

        for (String text: leftElements){
            System.out.println(text);
        }

        for (int index=0; index<2*key; index++){
            for (String element : rightElements){
                if (index<element.toCharArray().length)
                    processedText.append(element.toCharArray()[index]);
            }
            for (String element : leftElements){
                if (index<element.toCharArray().length)
                    processedText.append(element.toCharArray()[index]);
            }
        }

        return processedText.toString().trim();
    }
}
