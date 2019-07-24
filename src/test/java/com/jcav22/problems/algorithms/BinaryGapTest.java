package com.jcav22.problems.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {

    @ParameterizedTest
    @MethodSource("testValuesProvider")
    void solutionEasyTests(int expectedValue, int testValue) {
        assertEquals(expectedValue, BinaryGap.solution(testValue));
    }

    private static Stream<Arguments> testValuesProvider() {
        return Stream.of(
                Arguments.of(2, 9),
                Arguments.of(0, 15),
                Arguments.of(1, 20),
                Arguments.of(0, 32),
                Arguments.of(4, 529),
                Arguments.of(5, 1041),
                Arguments.of(2, 328),
                Arguments.of(3, 1162),
                Arguments.of(9, 66561)
        );
    }
}