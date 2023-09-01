package pl.pilichm.ciphers.square;

import pl.pilichm.ciphers.Cipher;
import pl.pilichm.util.Coordinates;

public class FourSquareCipher extends AbstractSquareCipher implements Cipher {
    private Character [][] key = {
            new Character[]{'a', 'b', 'c', 'd', 'e', 'E', 'X', 'A', 'M', 'P'},
            new Character[]{'f', 'g', 'h', 'i', 'j', 'L', 'B', 'C', 'D', 'F'},
            new Character[]{'k', 'l', 'm', 'n', 'o', 'G', 'H', 'I', 'J', 'K'},
            new Character[]{'p', 'r', 's', 't', 'u', 'N', 'O', 'R', 'S', 'T'},
            new Character[]{'v', 'w', 'x', 'y', 'z', 'U', 'V', 'W', 'Y', 'Z'},
            new Character[]{'K', 'E', 'Y', 'W', 'O', 'a', 'b', 'c', 'd', 'e'},
            new Character[]{'R', 'D', 'A', 'B', 'C', 'f', 'g', 'h', 'i', 'j'},
            new Character[]{'F', 'G', 'H', 'I', 'J', 'k', 'l', 'm', 'n', 'o'},
            new Character[]{'L', 'M', 'N', 'P', 'S', 'p', 'r', 's', 't', 'u'},
            new Character[]{'T', 'U', 'V', 'X', 'Z', 'v', 'w', 'x', 'y', 'z'}
    };

    public void setKey(Character[][] key) {
        for (int rowIdx=0; rowIdx<5; rowIdx++){
            for (int colIdx=0; colIdx<5; colIdx++){
                this.key[rowIdx][colIdx] = key[rowIdx][colIdx];
            }
        }
    }

    /**
     * Returns coordinates for letter. For encryption first letter coordinates are selected from upper left corner.
     * For second letter coordinates are selected from lower right corner.
     * For decryption first letter coordinates are selected from upper right corner and second letter from lower left corner.
     * @param letter -> Letter which coordinates should be found.
     * @param isFirstLetter -> True if passed letter is first letter of digram. False in other cases.
     * @param isEncryption -> True if coordinates will be used for encryption. False when for decryption.
     * @return -> coordinates of passed letter in key matrix.
     */
    private Coordinates getCoordinatesForLetter(Character letter, boolean isFirstLetter, boolean isEncryption){
        Coordinates result = new Coordinates();

        int startRowIdx = 0;
        int endRowIdx = key.length/2;
        int startColIdx = 0;
        int endColIdx = key.length/2;

        if (!isFirstLetter){
            startRowIdx = key.length/2;
            startColIdx = key.length/2;
            endRowIdx = key.length;
            endColIdx = key.length;
        }

        if (!isEncryption){
            startRowIdx = 0;
            startColIdx = key.length/2;
            endRowIdx = key.length/2;
            endColIdx = key.length;

            if (!isFirstLetter){
                startRowIdx = key.length/2;
                startColIdx = 0;
                endRowIdx = key.length;
                endColIdx = key.length/2;
            }
        }

        for (int rowIdx=startRowIdx; rowIdx<endRowIdx; rowIdx++){
            for (int coldIdx=startColIdx; coldIdx<endColIdx; coldIdx++){
                if (letter==Character.toUpperCase(key[rowIdx][coldIdx])){
                    result.setRowIdx(rowIdx);
                    result.setColIdx(coldIdx);
                }
            }
        }

        return result;
    }

    /**
     * Function for encrypting and decrypting String.
     * @param textToProcess -> text that should be encrypted or decrypted,
     * @param isEncryption -> True when operation is encryption, in that case input string is pad so that it contains
     *                     even number of characters.
     * @return -> String containing encrypted or decrypted text.
     */
    private String processText(String textToProcess, boolean isEncryption){
        StringBuilder processedText = new StringBuilder();
        textToProcess = clearText(textToProcess);

        if (isEncryption){
            textToProcess = prepareTextToEncode(textToProcess);
        }

        for (int index=0; index<textToProcess.length(); index+=2){
            Character firstLetter = textToProcess.toCharArray()[index];
            Character secondLetter = textToProcess.toCharArray()[index+1];

            Coordinates firstLetterCor = getCoordinatesForLetter(firstLetter, true, isEncryption);
            Coordinates secondLetterCor = getCoordinatesForLetter(secondLetter, false, isEncryption);

            Character [] result = processLettersFormingSquare(key, firstLetterCor, secondLetterCor);
            processedText.append(Character.toUpperCase(result[0]));
            processedText.append(Character.toUpperCase(result[1]));
            processedText.append(" ");
        }

        return processedText.toString().trim();
    }

    @Override
    public String encode(String textToEncode) {
        return processText(textToEncode, true);
    }

    @Override
    public String decode(String textToDecode) {
        return processText(textToDecode, false);
    }
}
