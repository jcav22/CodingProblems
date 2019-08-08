package com.jcav22.problems.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RiverFishTest {

    @Test
    void testSolution1() {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        assertEquals(2, RiverFish.solution(A, B));
    }

    @Test
    void testSolution2() {
        int[] A = {4, 3, 2, 1, 5, 7, 6, 8};
        int[] B = {1, 0, 0, 1, 1, 0, 1, 0};

        assertEquals(2, RiverFish.solution(A, B));
    }

    @Test
    void testSolutionAllSameDirection() {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {1, 1, 1, 1, 1};

        assertEquals(5, RiverFish.solution(A, B));
    }
}