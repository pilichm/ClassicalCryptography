package pl.pilichm.ciphers.square;

import pl.pilichm.ciphers.Cipher;
import pl.pilichm.util.Coordinates;

public class TwoSquareCipher extends AbstractSquareCipher implements Cipher {
    private Character [][] key = {
            new Character[]{'E', 'X', 'A', 'M', 'P'},
            new Character[]{'L', 'B', 'C', 'D', 'F'},
            new Character[]{'G', 'H', 'I', 'J', 'K'},
            new Character[]{'N', 'O', 'R', 'S', 'T'},
            new Character[]{'U', 'V', 'W', 'Y', 'Z'},
            new Character[]{'K', 'E', 'Y', 'W', 'O'},
            new Character[]{'R', 'D', 'A', 'B', 'C'},
            new Character[]{'F', 'G', 'H', 'I', 'J'},
            new Character[]{'L', 'M', 'N', 'P', 'S'},
            new Character[]{'T', 'U', 'V', 'X', 'Z'}
    };

    public void setKey(Character[][] key) {
        for (int rowIdx=0; rowIdx<5; rowIdx++){
            System.arraycopy(key[rowIdx], 0, this.key[rowIdx], 0, 5);
        }
    }

    private Coordinates getCoordinatesForLetter(Character letter, boolean isFirstLetter){
        Coordinates result = new Coordinates();

        int startRowIndex = 0;
        int startColIndex = 0;
        int endRowIndex = key.length/2;
        int endColIndex = key[0].length;

        if (!isFirstLetter){
            startRowIndex = key.length/2;
            endRowIndex = key.length;;
        }

        for (int rowIdx=startRowIndex; rowIdx<endRowIndex; rowIdx++){
            for (int coldIdx=startColIndex; coldIdx<endColIndex; coldIdx++){
                if (letter==Character.toUpperCase(key[rowIdx][coldIdx])){
                    result.setRowIdx(rowIdx);
                    result.setColIdx(coldIdx);
                }
            }
        }

        return result;
    }

    private String processText(String textToProcess, boolean isEncryption){
        StringBuilder processedText = new StringBuilder();

        textToProcess = clearText(textToProcess);

        if (isEncryption){
            textToProcess = prepareTextToEncode(textToProcess);
        }

        for (int index=0; index<textToProcess.length(); index+=2) {
            Character firstLetter = textToProcess.toCharArray()[index];
            Character secondLetter = textToProcess.toCharArray()[index+1];

            Coordinates firstLetterCor = getCoordinatesForLetter(firstLetter, true);
            Coordinates secondLetterCor = getCoordinatesForLetter(secondLetter, false);

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
