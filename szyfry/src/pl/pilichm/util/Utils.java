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

    public static void printMatrix(double[][] matrix){
        for (double[] doubles : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(doubles[col] + " ");
            }
            System.out.println("\n");
        }
    }

    public static double[][] multiplyMatrices(double[][] matrixA, double[][] matrixB) {
        double [][] resultMatrix = new double[matrixA.length][matrixB[0].length];

        for (int row=0; row < resultMatrix.length; row++){
            for (int col=0; col < resultMatrix[0].length; col++){
                double currentValue = 0;
                for (int index=0; index<matrixB.length; index++){
                    currentValue += matrixA[row][index] * matrixB[index][col];
                }
                resultMatrix[row][col] = currentValue;
            }
        }

        return resultMatrix;
    }
}
