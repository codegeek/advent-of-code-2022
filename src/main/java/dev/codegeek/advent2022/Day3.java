package dev.codegeek.advent2022;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class Day3 {
    private static final Logger log = Logger.getLogger("Day3");

    public static void main(String[] args) {
        var day3 = new Day3();
        day3.processFile("day3/input");
    }

    public void processFile(String filename) {
        Optional<List<String>> lines = Util.loadFile(filename);
        if(lines.isPresent()) {
            int totalScore = 0;
            for(String line : lines.get()) {
                totalScore += calculateScore1(line);
            }
            log.info("Total score 1: " + totalScore);
        }
    }

    public int calculateScore1(String line) {
        // Split line in two
        String rucksack1 = line.substring(0, line.length()/2);
        String rucksack2 = line.substring(line.length()/2);
        char commonItem = '?';
        for(char c : rucksack1.toCharArray()) {
            if (rucksack2.indexOf(c) >= 0) {
                commonItem = c;
                break;
            }
        }
        int score = 0;
        if (commonItem >= 'A' && commonItem <= 'Z') {
            score = commonItem - 38;
        }
        if (commonItem >= 'a' && commonItem <= 'z') {
            score = commonItem - 96;
        }
        return score;
    }
}
