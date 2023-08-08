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
     * @param firstLetter -> first letter for encryption.
     * @param secondLetter -> second letter for encryption.
     * @return -> Two encrypted letters as array.
     */
    private Character[] encryptLetter(Character firstLetter, Character secondLetter){
        Character [] result = new Character[2];

        Coordinates firstLetterCor = getLocationOfLetter(firstLetter);
        Coordinates secondLetterCor = getLocationOfLetter(secondLetter);

        /*
         * If letters form column pick letter below each letter. Wrap to top if needed.
         */
        if (firstLetterCor.getColIdx()==secondLetterCor.getColIdx()
                && firstLetterCor.getRowIdx()!=secondLetterCor.getRowIdx()){
            if (firstLetterCor.getRowIdx()==4){
                result[0] = key[0][firstLetterCor.getColIdx()];
            } else {
                result[0] = key[firstLetterCor.getRowIdx()+1][firstLetterCor.getColIdx()];
            }

            if (secondLetterCor.getRowIdx()==4){
                result[1] = key[0][secondLetterCor.getColIdx()];
            } else {
                result[1] = key[secondLetterCor.getRowIdx()+1][secondLetterCor.getColIdx()];
            }
        }

        /*
         * If letters form row select letters right of each letter. Wrap to left if needed.
         */
        if (firstLetterCor.getRowIdx()==secondLetterCor.getRowIdx()
                && firstLetterCor.getColIdx()!=secondLetterCor.getColIdx()){
            if (firstLetterCor.getColIdx()==4){
                result[0] = key[firstLetterCor.getRowIdx()][0];
            } else {
                result[0] = key[firstLetterCor.getRowIdx()][firstLetterCor.getColIdx()+1];
            }

            if (secondLetterCor.getColIdx()==4){
                result[1] = key[secondLetterCor.getRowIdx()][0];
            } else {
                result[1] = key[secondLetterCor.getRowIdx()][secondLetterCor.getColIdx()+1];
            }
        }

        return result;
    }

    public void test(){
        Character [] res = encryptLetter('D', 'E');
        System.out.println(res[0] + " " + res[1]);

        res = encryptLetter('E', 'X');
        System.out.println(res[0] + " " + res[1]);
    }
}
