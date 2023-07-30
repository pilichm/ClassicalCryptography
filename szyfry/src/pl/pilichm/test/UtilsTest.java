package pl.pilichm.test;

import pl.pilichm.util.Utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {
    private final double[][] firstMatrix = {
            new double[]{1, 5},
            new double[]{2, 3},
            new double[]{1, 7}
    };

    private final double[][] secondMatrix = {
            new double[]{1, 2, 3, 7},
            new double[]{5, 2, 8, 1}
    };

    private final double[][] correctResultMatrix = {
            new double[]{26, 12, 43, 12},
            new double[]{17, 10, 30, 17},
            new double[]{36, 16, 59, 14}
    };

    private final double[][] matrixForTwoTwoDeterminant = {
            new double[]{1, 2},
            new double[]{3, 4}
    };

    double[][] matrixForThreeThreeDeterminant = {
            new double[]{2, -3, 1},
            new double[]{2, 0, -1},
            new double[]{1, 4, 5}
    };

    @org.junit.jupiter.api.Test
    void multiplyMatrices() {
        double [][] resultMatrix = Utils.multiplyMatrices(firstMatrix, secondMatrix);
        assertArrayEquals(correctResultMatrix, resultMatrix);
    }

    @org.junit.jupiter.api.Test
    void calcDeterminantForTwoTwoMatrix() {
        double calculatedDeterminant = Utils.calcDeterminantForTwoTwoMatrix(matrixForTwoTwoDeterminant);
        double determinantForTwoTwoMatrix = -2;
        assertEquals(calculatedDeterminant, determinantForTwoTwoMatrix);
    }

    @org.junit.jupiter.api.Test
    void calcDeterminantForThreeThreeMatrix() {
        double calculatedDeterminant = Utils.calcDeterminantForThreeThreeMatrix(matrixForThreeThreeDeterminant);
        double determinantForThreeThreeMatrix = 49;
        assertEquals(calculatedDeterminant, determinantForThreeThreeMatrix);
    }

    @org.junit.jupiter.api.Test
    void calcExtendedMatrix() {
        double[][] matrixIn = {
                new double[]{2, 5, 7},
                new double[]{6, 3, 4},
                new double[]{5, -2, -3}
        };

        double[][] correctResultMatrix = {
                new double[]{-1.0, 38.0, -27.0},
                new double[]{1.0, -41.0, 29.0},
                new double[]{-1.0, 34.0, -24.0 }
        };

        assertArrayEquals(Utils.calcExtendedMatrix(matrixIn), correctResultMatrix);
    }

    @org.junit.jupiter.api.Test
    void transposeMatrix() {
        double[][] matrixIn = {
                new double[]{-1.0, 38.0, -27.0},
                new double[]{1.0, -41.0, 29.0},
                new double[]{-1.0, 34.0, -24.0 }
        };

        double[][] transposedMatrix = {
                new double[]{-1.0, 1.0, -1.0},
                new double[]{38.0, -41.0, 34.0},
                new double[]{-27.0, 29.0, -24.0}
        };

        assertArrayEquals(Utils.transposeMatrix(matrixIn), transposedMatrix);
    }

    @org.junit.jupiter.api.Test
    void multipleMatrixByValueWithModulo() {
        double[][] matrix = {
                new double[]{6, 24, 1},
                new double[]{13, 16, 10},
                new double[]{20, 17, 15}
        };

        double[][] correctResultMatrix = {
                new double[]{20, 2, 25},
                new double[]{13, 10, 16},
                new double[]{6, 9, 11}
        };

        double multiplier = 25;
        double modulo = 26;

        assertArrayEquals(Utils.multipleMatrixByValueWithModulo(matrix, multiplier, modulo), correctResultMatrix);
    }

    @org.junit.jupiter.api.Test
    void calcInvertedModuloMatrix() {
        double[][] matrix = {
                new double[]{6, 24, 1},
                new double[]{13, 16, 10},
                new double[]{20, 17, 15}
        };

        double[][] correctResultMatrix = {
                new double[]{8, 5, 10},
                new double[]{21, 8, 21},
                new double[]{21, 12, 8}
        };

        assertArrayEquals(Utils.calcInvertedModuloMatrix(matrix, 26), correctResultMatrix);
    }
}