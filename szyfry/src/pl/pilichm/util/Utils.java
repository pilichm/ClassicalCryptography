package pl.pilichm.util;

import java.util.ArrayList;

public class Utils {
    public static Character[][] getTabulaRectaForLanguage(SupportedLanguages language) {
        ArrayList<Character> alphabet;

        if (language == SupportedLanguages.POLISH) {
            alphabet = new ArrayList<>(Constants.alphabetPolish);
        } else {
            alphabet = new ArrayList<>(Constants.alphabetEnglish);
        }

        Character [][] tabulaRecta = new Character[alphabet.size()][alphabet.size()];

        for (int row_idx = 0; row_idx < alphabet.size(); row_idx++){
            for (int col_idx = 0; col_idx < alphabet.size(); col_idx++){
                int currentLetterIndex = (col_idx + row_idx) % alphabet.size();

                if (currentLetterIndex < 0) {
                    currentLetterIndex += alphabet.size();
                }

                tabulaRecta[row_idx][col_idx] = alphabet.get(currentLetterIndex);
            }
        }

        return tabulaRecta;
    }
}
