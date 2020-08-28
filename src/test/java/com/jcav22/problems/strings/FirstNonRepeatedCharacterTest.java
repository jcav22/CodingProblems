package com.jcav22.problems.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstNonRepeatedCharacterTest {

    @Test
    void detect() {
        assertEquals("o", FirstNonRepeatedCharacter.detect("total"));
        assertEquals("r", FirstNonRepeatedCharacter.detect("teeter"));
    }
}