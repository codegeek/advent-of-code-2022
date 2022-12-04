package dev.codegeek.advent2022;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Day4 {
    private static final Logger log = Logger.getLogger("Day4");

    public static void main(String[] args) {
        Day4 day4 = new Day4();
        day4.processFile("day4/input");
    }

    public void processFile(String filename) {
        Optional<List<String>> lines = Util.loadFile(filename);
        if (lines.isPresent()) {
            int totalScore1 = calculateScore1(lines.get());

            log.info("Total score 1: " + totalScore1);
        }
    }

    public int calculateScore1(List<String> lines) {
        int totalScore = 0;
        for(String line : lines) {
            var sections = line.split(",");
            var firstRange = sections[0].split("-");
            var firstSection = IntStream.range(Integer.parseInt(firstRange[0]), Integer.parseInt(firstRange[1]) + 1).toArray();
            var secondRange = sections[1].split("-");
            var secondSection = IntStream.range(Integer.parseInt(secondRange[0]), Integer.parseInt(secondRange[1]) + 1).toArray();

            if (isSubArray(firstSection, secondSection) || isSubArray(secondSection, firstSection)) {
                totalScore++;
            }
        }
        return totalScore;
    }

    private boolean isSubArray(final int[] first, final int[] second) {
        int i = 0, j = 0;
        int n = first.length, m = second.length;

        while (i < n && j < m) {
            if (first[i] == second[j]) {
                i++; j++;
                if (j == m) {
                    return true;
                }
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return false;
    }
}
