package com.jcav22.problems.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationArrayTest {

    @Test
    void testSolution1() {
        int K = 3;
        int[] A1 = {3, 8, 9, 7, 6};
        int[] expectedResult = {9, 7, 6, 3, 8};

        executeTest(A1, expectedResult, K);
    }

    @Test
    void testSolution2() {
        int K = 1;
        int[] A1 = {0, 0, 0};
        int[] expectedResult = {0, 0, 0};

        executeTest(A1, expectedResult, K);
    }

    @Test
    void testSolution3() {
        int K = 4;
        int[] A1 = {3, 8, 9, 7, 6, 8, 7, 3};
        int[] expectedResult = {6, 8, 7, 3, 3, 8, 9, 7};

        executeTest(A1, expectedResult, K);
    }

    @Test
    void testSolution4() {
        int K = 7;
        int[] A1 = {3, 8, 9, 7, 6, 8, 7, 3};
        int[] expectedResult = {8, 9, 7, 6, 8, 7, 3, 3};

        executeTest(A1, expectedResult, K);
    }

    @Test
    void testSolutionEmptyArray() {
        int K = 1;
        int[] A1 = {};

        executeTest(A1, A1, K);
    }

    @Test
    void testSolutionLenght1() {
        int K = 1;
        int[] A1 = {2};
        int[] expectedResult = {2};

        executeTest(A1, expectedResult, K);
    }

    @Test
    void testSolutionSameNumOfElements() {
        int[] A1 = {3, 8, 9, 7, 6};

        executeTest(A1, A1, A1.length);
    }

    @Test
    void testSolutionMaximalRotations() {
        int K = 42;
        int[] A1 = {1, 1, 2, 3, 5};
        int[] expectedResult = {3, 5, 1, 1, 2};

        executeTest(A1, expectedResult, K);
    }

    private void executeTest(int[] A, int[] expected, int K) {
        int[] result = CyclicRotationArray.solution(A, K);

        assertEquals(A.length, result.length);
        checkArrayValues(A, expected, result);
    }

    private void checkArrayValues(int[] a1, int[] expectedResult, int[] result) {
        for (int i = 0; i < a1.length; i++) {
            if (result[i] != expectedResult[i]) {
                fail("Elements does not match");
            }
        }
    }
}