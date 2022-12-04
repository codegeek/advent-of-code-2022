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
            int totalScore2 = calculateScore2(lines.get());

            log.info("Total score 1: " + totalScore1);
            log.info("Total score 2: " + totalScore2);
        }
    }

    public int calculateScore1(List<String> lines) {
        int totalScore = 0;
        for(String line : lines) {
            var sections = line.split(",");
            var firstSection = getSectionArray(sections[0]);
            var secondSection = getSectionArray(sections[1]);

            if (isSubArray(firstSection, secondSection) || isSubArray(secondSection, firstSection)) {
                totalScore++;
            }
        }
        return totalScore;
    }

    public int calculateScore2(List<String> lines) {
        int totalScore = 0;
        for(String line : lines) {
            var sections = line.split(",");
            var firstSection = getSectionArray(sections[0]);
            var secondSection = getSectionArray(sections[1]);

            if(isOverlap(firstSection, secondSection)) {
                totalScore++;
            }
        }
        return totalScore;
    }

    private int[] getSectionArray(String section) {
        var range = section.split("-");
        return IntStream.range(Integer.parseInt(range[0]), Integer.parseInt(range[1]) + 1).toArray();
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

    private boolean isOverlap(final int[] first, final int[] second) {
        for (int j : first) {
            for (int k : second) {
                if (j == k) {
                    return true;
                }
            }
        }
        return false;
    }
}
