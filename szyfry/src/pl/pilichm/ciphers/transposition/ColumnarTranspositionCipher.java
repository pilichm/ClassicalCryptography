package pl.pilichm.ciphers.transposition;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;
import pl.pilichm.util.Utils;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ColumnarTranspositionCipher extends AbstractCipher implements Cipher {
    private String key;

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String encode(String textToEncode) {
        StringBuilder processedText = new StringBuilder();
        textToEncode = textToEncode.toUpperCase();
        Utils<Character> utils = new Utils<>();

        if (key==null ||  key.equalsIgnoreCase("")){
            return processedText.toString();
        }

        int numberOfRows = textToEncode.length()/key.length();
        int numberOfCols = key.length();

        if (textToEncode.length()%key.length()!=0){
            System.out.println("add 1");
            numberOfRows += 1;
        }

        Character [][] plainTextArray = createCharArrayWithRandomValues(numberOfRows, numberOfCols);
        System.out.println("Array of random letters:");
        utils.printMatrix(plainTextArray);

        CharacterIterator it = new StringCharacterIterator(textToEncode);
        int currentRowIdx = 0;
        int currentColIdx = 0;

        while (it.current() != CharacterIterator.DONE) {
            if (!" ".equalsIgnoreCase(String.valueOf(it.current()))&&!nonLetterCharacters.contains(it.current())){
                plainTextArray[currentRowIdx][currentColIdx] = it.current();
                currentColIdx += 1;

                if (currentColIdx==numberOfCols){
                    currentColIdx = 0;
                    currentRowIdx += 1;
                }

            }

            it.next();
        }

        System.out.println("Array of plaintext letters:");
        utils.printMatrix(plainTextArray);

        int [] columnOrder = getColumnOrderFromKey();
        System.out.println("Column order from key:");
        for (int index=0; index<columnOrder.length; index++) {
            System.out.print(columnOrder[index] + " ");
        }
        System.out.println();

        for (int index=0; index<columnOrder.length; index++){
            for (int rowIndex=0; rowIndex<numberOfRows; rowIndex++){
                processedText.append(plainTextArray[rowIndex][columnOrder[index]]);
            }
            processedText.append(" ");
        }

        return processedText.toString();
    }

    /**
     * Returns character array filled with random upper case letters.
     * @param numberOfRows -> number of rows in returned array.
     * @param numberOfCols -> number of columns in returned array.
     * @return -> Array filled with random upper case letters.
     */
    private Character [][] createCharArrayWithRandomValues(int numberOfRows, int numberOfCols){
        Character [][] characterArray = new Character[numberOfRows][numberOfCols];
        ArrayList<Character> alphabet = getAlphabet();

        for (int row=0; row<numberOfRows; row++){
            for (int col=0; col<numberOfCols; col++){
            characterArray[row][col] = alphabet.get(ThreadLocalRandom.current().nextInt(0,  alphabet.size()));
            }
        }

        return characterArray;
    }

    /**
     * Converts string encryption/decryption key to array of ints determining reading order of columns in encryption matrix.
     * @return -> int array of matrix columns order.
     */
    private int [] getColumnOrderFromKey(){
        int [] columnOrder = new int[key.length()];
        ArrayList<Character> alphabet = getAlphabet();

        class KeyElement{
            final int charValue;
            final int originalIndex;

            public KeyElement(int charValue, int originalIndex){
                this.charValue = charValue;
                this.originalIndex = originalIndex;
            }
        }

        ArrayList<KeyElement> keyElements = new ArrayList<>();

        for (int index=0; index<key.length(); index++){
            keyElements.add(new KeyElement(
                    alphabet.indexOf(key.toCharArray()[index]),
                    index
            ));
        }

        keyElements.sort((o1, o2) -> {
            if (o1.charValue == o2.charValue) {
                return 0;
            }

            return o1.charValue < o2.charValue ? -1 : 1;
        });

        for (int index=0; index<key.length(); index++){
            columnOrder[index] = keyElements.get(index).originalIndex;
        }

        return columnOrder;
    }
}
