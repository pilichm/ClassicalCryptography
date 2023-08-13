package pl.pilichm.ciphers.square;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.util.Coordinates;

public class AbstractSquareCipher extends AbstractCipher {
    /**
     * For a pair of letters coordinates returns letters from opposing corners of square formed by letters coordinates,
     * @param firstLetterCor -> coordinates of first letter.
     * @param secondLetterCor -> coordinates of second letter.
     * @param key -> encryption key in form of character array.
     * @return -> Array containing a pair of letters from opposing corners.
     */
    public Character [] processLettersFormingSquare(Character [][] key, Coordinates firstLetterCor, Coordinates secondLetterCor){
        Character [] result = new Character[2];
        result[0] = key[firstLetterCor.getRowIdx()][secondLetterCor.getColIdx()];
        result[1] = key[secondLetterCor.getRowIdx()][firstLetterCor.getColIdx()];
        return result;
    }
}
