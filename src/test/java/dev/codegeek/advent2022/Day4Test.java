package dev.codegeek.advent2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Test {
    private static final List<String> TEST_LINES = List.of("2-4,6-8",
            "2-3,4-5",
            "5-7,7-9",
            "2-8,3-7",
            "6-6,4-6",
            "2-6,4-8");
    private final Day4 day4 = new Day4();

    @Test
    void testCalculateScore1() {
        assertEquals(2, day4.calculateScore1(TEST_LINES));
    }

    @Test
    void testCalculateScore2() {
        assertEquals(4, day4.calculateScore2(TEST_LINES));
    }
}
