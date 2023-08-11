package pl.pilichm.ciphers.square;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;

public class PlayfairCipher extends AbstractCipher implements Cipher {
    private Character [][] key = {
            new Character[]{'P', 'L', 'A', 'Y', 'F'},
            new Character[]{'I', 'R', 'E', 'X', 'M'},
            new Character[]{'B', 'C', 'D', 'G', 'H'},
            new Character[]{'K', 'N', 'O', 'Q', 'S'},
            new Character[]{'T', 'U', 'V', 'W', 'Z'}
    };

    /**
     * Class for holding row and column number of letter.
     */
    private static class Coordinates{
        private int rowIdx;
        private int colIdx;

        public Coordinates(){
            this.rowIdx = -1;
            this.colIdx = -1;
        }

        public int getRowIdx() {
            return rowIdx;
        }

        public int getColIdx() {
            return colIdx;
        }

        public void setRowIdx(int rowIdx) {
            this.rowIdx = rowIdx;
        }

        public void setColIdx(int colIdx) {
            this.colIdx = colIdx;
        }

        @Override
        public String toString() {
            return "Row: " + this.rowIdx + ", col: " + colIdx;
        }
    }

    /**
     * Function for searching of row and column indexes for given letter.
     * @param letter -> letter which row and column number must be found.
     * @return -> Coordinates in key array of given letter.
     */
    private Coordinates getLocationOfLetter(Character letter){
        Coordinates result = new Coordinates();

        if (letter=='J'){
            letter = 'I';
        }

        for (int rowIdx=0; rowIdx<key.length; rowIdx++){
            for (int colIdx=0; colIdx<key[0].length; colIdx++){
                if (key[rowIdx][colIdx]==letter){
                    result.setRowIdx(rowIdx);
                    result.setColIdx(colIdx);
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Encrypts a pair of letters.
     * If letters form column pick letter below each letter. Wrap to top if needed.
     * If letters form row select letters right of each letter. Wrap to left if needed.
     * If letters form square return letters from opposite corners.
     * @param firstLetter -> first letter for encryption.
     * @param secondLetter -> second letter for encryption.
     * @return -> Two encrypted letters as array.
     */
    private Character[] encryptLetters(Character firstLetter, Character secondLetter){
        Character [] result = new Character[2];

        Coordinates firstLetterCor = getLocationOfLetter(firstLetter);
        Coordinates secondLetterCor = getLocationOfLetter(secondLetter);

        if (firstLetterCor.getColIdx()==secondLetterCor.getColIdx()
                && firstLetterCor.getRowIdx()!=secondLetterCor.getRowIdx()){
            if (firstLetterCor.getRowIdx()==key.length){
                result[0] = key[0][firstLetterCor.getColIdx()];
            } else {
                result[0] = key[firstLetterCor.getRowIdx()+1][firstLetterCor.getColIdx()];
            }

            if (secondLetterCor.getRowIdx()==key.length){
                result[1] = key[0][secondLetterCor.getColIdx()];
            } else {
                result[1] = key[secondLetterCor.getRowIdx()+1][secondLetterCor.getColIdx()];
            }
        }

        if (firstLetterCor.getRowIdx()==secondLetterCor.getRowIdx()
                && firstLetterCor.getColIdx()!=secondLetterCor.getColIdx()){
            if (firstLetterCor.getColIdx()==key[0].length){
                result[0] = key[firstLetterCor.getRowIdx()][0];
            } else {
                result[0] = key[firstLetterCor.getRowIdx()][firstLetterCor.getColIdx()+1];
            }

            if (secondLetterCor.getColIdx()==key[0].length){
                result[1] = key[secondLetterCor.getRowIdx()][0];
            } else {
                result[1] = key[secondLetterCor.getRowIdx()][secondLetterCor.getColIdx()+1];
            }
        }

        result = processLettersFormingSquare(firstLetterCor, secondLetterCor);

        return result;
    }

    /**
     * Decrypts a pair of letters.
     * If letters form column pick letter above each letter. Wrap to down if needed.
     * If letters form row select letters left of each letter. Wrap to right if needed.
     * If letters form square return letters from opposite corners.
     * @param firstLetter -> first letter for encryption.
     * @param secondLetter -> second letter for encryption.
     * @return -> Two decrypted letters as array.
     */
    private Character[] decryptLetters(Character firstLetter, Character secondLetter) {
        Character [] result = new Character[2];

        Coordinates firstLetterCor = getLocationOfLetter(firstLetter);
        Coordinates secondLetterCor = getLocationOfLetter(secondLetter);

        if (firstLetterCor.getColIdx()==secondLetterCor.getColIdx()
                && firstLetterCor.getRowIdx()!=secondLetterCor.getRowIdx()){
            if (firstLetterCor.getRowIdx()==0){
                result[0] = key[key.length-1][firstLetterCor.getColIdx()];
            } else {
                result[0] = key[firstLetterCor.getRowIdx()-1][firstLetterCor.getColIdx()];
            }

            if (secondLetterCor.getRowIdx()==0){
                result[1] = key[key.length-1][secondLetterCor.getColIdx()];
            } else {
                result[1] = key[secondLetterCor.getRowIdx()-1][secondLetterCor.getColIdx()];
            }
        }

        if (firstLetterCor.getRowIdx()==secondLetterCor.getRowIdx()
                && firstLetterCor.getColIdx()!=secondLetterCor.getColIdx()){
            if (firstLetterCor.getColIdx()==0){
                result[0] = key[firstLetterCor.getRowIdx()][key.length-1];
            } else {
                result[0] = key[firstLetterCor.getRowIdx()][firstLetterCor.getColIdx()-1];
            }

            if (secondLetterCor.getColIdx()==0){
                result[1] = key[secondLetterCor.getRowIdx()][key.length-1];
            } else {
                result[1] = key[secondLetterCor.getRowIdx()][secondLetterCor.getColIdx()-1];
            }
        }

        result = processLettersFormingSquare(firstLetterCor, secondLetterCor);

        return result;
    }

    /**
     * For a pair of letters coordinates returns letters from opposing corners of square formed by letters coordinates,
     * @param firstLetterCor -> coordinates of first letter.
     * @param secondLetterCor -> coordinates of second letter.
     * @return -> Array containing a pair of letters from opposing corners.
     */
    private Character [] processLettersFormingSquare(Coordinates firstLetterCor, Coordinates secondLetterCor){
        Character [] result = new Character[2];
        result[0] = key[firstLetterCor.getRowIdx()][secondLetterCor.getColIdx()];
        result[1] = key[secondLetterCor.getRowIdx()][firstLetterCor.getColIdx()];
        return result;
    }

    @Override
    public String encode(String textToEncode) {
        StringBuilder processedText = new StringBuilder();
        textToEncode = textToEncode.toUpperCase();
        textToEncode = textToEncode.replace(" ", "");

        for (Character letter : getAlphabet()){
            if (textToEncode.contains(letter + String.valueOf(letter))){
                textToEncode = textToEncode.replace(letter + String.valueOf(letter), letter + "X" + String.valueOf(letter));
            }
        }

        if (textToEncode.length()%2!=0){
            textToEncode = textToEncode + 'X';
        }

        for (int index=0; index<textToEncode.length(); index+=2){
            Character firstLetter = textToEncode.toCharArray()[index];
            Character secondLetter = textToEncode.toCharArray()[index + 1];

            Character [] encodedLetters = encryptLetters(firstLetter, secondLetter);
            processedText.append(encodedLetters[0]);
            processedText.append(encodedLetters[1]);
        }

        return processedText.toString();
    }

    @Override
    public String decode(String textToDecode) {
        StringBuilder processedText = new StringBuilder();

        if (textToDecode.length()%2!=0){
            return processedText.toString();
        }

        for (int index=0; index<textToDecode.length(); index+=2) {
            Character firstLetter = textToDecode.toCharArray()[index];
            Character secondLetter = textToDecode.toCharArray()[index + 1];

            Character [] encodedLetters = decryptLetters(firstLetter, secondLetter);
            processedText.append(encodedLetters[0]);
            processedText.append(encodedLetters[1]);
        }

        return processedText.toString();
    }

    public void test(){
        Character [] res = decryptLetters('B', 'M');
        System.out.println(res[0] + " " + res[1]);

        res = decryptLetters('Z', 'B');
        System.out.println(res[0] + " " + res[1]);

        res = decryptLetters('X', 'M');
        System.out.println(res[0] + " " + res[1]);

        res = decryptLetters('O', 'D');
        System.out.println(res[0] + " " + res[1]);
    }
}
