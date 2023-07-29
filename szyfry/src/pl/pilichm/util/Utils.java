package pl.pilichm.util;

import java.util.ArrayList;
import java.util.List;

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

    public static double calcDeterminantForTwoTwoMatrix(double [][] matrixIn){
        return matrixIn[0][0] * matrixIn[1][1] - matrixIn[0][1] * matrixIn[1][0];
    }

    public static double calcDeterminantForThreeThreeMatrix(double [][] matrixIn){
        double determinant = 0;

        double [][] firstMatrix = {
                new double[]{matrixIn[1][1], matrixIn[1][2]},
                new double[]{matrixIn[2][1], matrixIn[2][2]}
        };

        double [][] secondMatrix = {
                new double[]{matrixIn[1][0], matrixIn[1][2]},
                new double[]{matrixIn[2][0], matrixIn[2][2]}
        };

        double [][] thirdMatrix = {
                new double[]{matrixIn[1][0], matrixIn[1][1]},
                new double[]{matrixIn[2][0], matrixIn[2][1]}
        };

        determinant = matrixIn[0][0] * calcDeterminantForTwoTwoMatrix(firstMatrix)
                - matrixIn[0][1] * calcDeterminantForTwoTwoMatrix(secondMatrix)
                + matrixIn[0][2] * calcDeterminantForTwoTwoMatrix(thirdMatrix);

        return determinant;
    }

    public static double calcCofactorMatrixDeterminant(double [][] matrixIn, int rowIndex, int colIndex){
        double [][] cofactorMatrix = new double[matrixIn.length-1][matrixIn.length-1];

        List<Double> correctElements = new ArrayList<>();

        for (int rowIdx=0; rowIdx<matrixIn.length; rowIdx++){
            for (int colIdx=0; colIdx<matrixIn.length; colIdx++){
                if (rowIdx!=rowIndex && colIdx!=colIndex){
                    correctElements.add(matrixIn[rowIdx][colIdx]);
                }
            }
        }

        int counter = 0;

        for (int rowIdx=0; rowIdx<cofactorMatrix.length; rowIdx++){
            for (int colIdx=0; colIdx<cofactorMatrix.length; colIdx++){
                cofactorMatrix[rowIdx][colIdx] = correctElements.get(counter);
                counter += 1;
            }
        }

        return calcDeterminantForTwoTwoMatrix(cofactorMatrix);
    }

    public static double [][] calcExtendedMatrix(double [][] matrixIn){
        return new double[][]{
                new double[]{calcCofactorMatrixDeterminant(matrixIn, 0, 0),
                        -1.0d * calcCofactorMatrixDeterminant(matrixIn, 0, 1),
                        calcCofactorMatrixDeterminant(matrixIn, 0, 2)},
                new double[]{-1.0d * calcCofactorMatrixDeterminant(matrixIn, 1, 0),
                        calcCofactorMatrixDeterminant(matrixIn, 1, 1),
                        -1.0d * calcCofactorMatrixDeterminant(matrixIn, 1, 2)},
                new double[]{calcCofactorMatrixDeterminant(matrixIn, 2, 0),
                        -1.0d * calcCofactorMatrixDeterminant(matrixIn, 2, 1),
                        calcCofactorMatrixDeterminant(matrixIn, 2, 2)}
        };
    }

    public static double [][] transposeMatrix(double [][] matrixIn){
        double [][] matrixOut = new double[matrixIn.length][matrixIn.length];

        for (int rowIndex=0; rowIndex<matrixIn.length; rowIndex++){
            for (int colIndex=0; colIndex<matrixIn[0].length; colIndex++){
                matrixOut[colIndex][rowIndex] = matrixIn[rowIndex][colIndex];
            }
        }

        return matrixOut;
    }

    public static double [][] divideMatrixByValue(double [][] matrixIn, double value){
        for (int rowIdx=0; rowIdx<matrixIn.length; rowIdx++){
            for (int colIdx=0; colIdx<matrixIn.length; colIdx++){
                matrixIn[rowIdx][colIdx] = matrixIn[rowIdx][colIdx]/value;
            }
        }

        return matrixIn;
    }

    public static double [][] calcInvertedMatrix(double [][] matrixIn){
        double [][] matrixOut = Utils.calcExtendedMatrix(matrixIn);
        double determinant = Utils.calcDeterminantForThreeThreeMatrix(matrixIn);

        matrixOut = Utils.transposeMatrix(matrixOut);

        if (determinant!=0){
            matrixOut = Utils.divideMatrixByValue(matrixOut, determinant);
        }

        return matrixOut;
    }

}
