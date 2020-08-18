package com.jcav22.problems.strings;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindAnagramsTest {

    @ParameterizedTest
    @MethodSource("sequencesProvider")
    void findAnagrams(String sequence, String pattern, List<Integer> expectedResult) {
        List<Integer> result = FindAnagrams.findAnagrams(sequence, pattern);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> sequencesProvider() {
        return Stream.of(
                Arguments.of("cbaebabacd", "abc", List.of(0, 6)),
                Arguments.of("ababababab", "aab", List.of(0, 2, 4, 6)),
                Arguments.of("baa", "aa", List.of(1))
        );
    }

    @Test
    void isAnagram() {
        assertFalse(FindAnagrams.isAnagram("bab", "aab"));
        assertTrue(FindAnagrams.isAnagram("bab", "abb"));
    }
}