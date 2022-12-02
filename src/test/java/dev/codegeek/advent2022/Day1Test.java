package dev.codegeek.advent2022;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {
    private final Day1 day1 = new Day1();

    @Test
    void testCalculateScore1() {
        assertEquals(24000, day1.calculateScore1(createTestElves()));
    }

    @Test
    void testCalculateScore2() {
        assertEquals(45000, day1.calculateScore2(createTestElves()));
    }

    private Set<Day1.Elf> createTestElves() {
        var elves = new HashSet<Day1.Elf>();
        elves.add(new Day1.Elf(List.of(1000, 2000, 3000)));
        elves.add(new Day1.Elf(List.of(4000)));
        elves.add(new Day1.Elf(List.of(5000, 6000)));
        elves.add(new Day1.Elf(List.of(7000, 8000, 9000)));
        elves.add(new Day1.Elf(List.of(10000)));

        return elves;
    }
}
