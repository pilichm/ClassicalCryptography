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

    /**
     * Prepares plaintext for encryption. Non letter characters are removed. If text len is not even then additional
     * character is appended to end.
     * @param textToEncode -> String text for processing.
     * @return -> Text without non letter characters with even length.
     */
    public String prepareTextToEncode(String textToEncode){
        for (Character letter : nonLetterCharacters){
            if (textToEncode.contains(letter.toString())){
                textToEncode = textToEncode.replace(letter.toString(), "");
            }
        }

        if (textToEncode.length()%2!=0){
            textToEncode = textToEncode + 'X';
        }

        return textToEncode;
    }

    /**
     * Converts text to upper case and removes spaces.
     * @param textIn -> text for processing.
     * @return -> text with removed spaces and converted to upper case.
     */
    public String clearText(String textIn){
        textIn = textIn.toUpperCase();
        textIn = textIn.replace(" ", "");
        return textIn;
    }
}
