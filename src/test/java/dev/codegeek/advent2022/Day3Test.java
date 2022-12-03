package dev.codegeek.advent2022;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {
    private final Day3 day3 = new Day3();

    private static final String[] TEST_LINES = {"vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"};

    @Test
    void testCalculateScore1() {
        assertEquals(16, day3.calculateScore1(TEST_LINES[0]));
        assertEquals(38, day3.calculateScore1(TEST_LINES[1]));
        assertEquals(42, day3.calculateScore1(TEST_LINES[2]));
        assertEquals(22, day3.calculateScore1(TEST_LINES[3]));
        assertEquals(20, day3.calculateScore1(TEST_LINES[4]));
        assertEquals(19, day3.calculateScore1(TEST_LINES[5]));
    }

    @Test
    void testCalculateScore2() {
        assertEquals(18, day3.calculateScore2(TEST_LINES[0], TEST_LINES[1], TEST_LINES[2]));
        assertEquals(52, day3.calculateScore2(TEST_LINES[3], TEST_LINES[4], TEST_LINES[5]));
    }
}
