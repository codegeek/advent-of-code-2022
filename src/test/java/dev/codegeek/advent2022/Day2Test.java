package dev.codegeek.advent2022;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {
    @Test
    void testFinalScore() {
        var day2 = new Day2();
        assertEquals(8, day2.calculateScore("A", "Y"));
        assertEquals(1, day2.calculateScore("B", "X"));
        assertEquals(6, day2.calculateScore("C", "Z"));
    }
}
