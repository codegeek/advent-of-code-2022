package dev.codegeek.advent2022;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {
    private final Day2 day2 = new Day2();

    @Test
    void testCalculateScore1() {
        assertEquals(8, day2.calculateScore1("A", "Y"));
        assertEquals(1, day2.calculateScore1("B", "X"));
        assertEquals(6, day2.calculateScore1("C", "Z"));
    }

    @Test
    void testCalculateScore2() {
        assertEquals(4, day2.calculateScore2("A", "Y"));
        assertEquals(1, day2.calculateScore2("B", "X"));
        assertEquals(7, day2.calculateScore2("C", "Z"));
    }
}
