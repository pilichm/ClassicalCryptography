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
}