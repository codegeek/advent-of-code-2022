package dev.codegeek.advent2022;

import java.util.Map;
import java.util.logging.Logger;

public class Day2 {
    private static final Logger log = Logger.getLogger("Day2");

    private final Map<String, Integer> shapeValue = Map.of("X", 1, "Y", 2, "Z", 3);

    public static void main(String[] args) {
        var day2 = new Day2();
        day2.processFile("day2/input");
    }

    public void processFile(String filename) {
        var optionalLines = Util.loadFile(filename);
        if (optionalLines.isPresent()) {
            int totalScore1 = 0, totalScore2 = 0;
            for(String line : optionalLines.get()) {
                var choices = line.split(" ");
                totalScore1 += calculateScore1(choices[0], choices[1]);
                totalScore2 += calculateScore2(choices[0], choices[1]);
            }
            log.info("Total score Part 1: " + totalScore1);
            log.info("Total score Part 2: " + totalScore2);
        } else {
            log.severe("Could not find file: " + filename);
        }
    }

    public int calculateScore1(String opponentChoice, String myChoice) {
        int finalScore = shapeValue.get(myChoice);
        switch (opponentChoice) {
            case "A" -> {
                switch (myChoice) {
                    case "X" ->  finalScore += 3; // Tie
                    case "Y" ->  finalScore += 6; // Paper defeats Rock
                    case "Z" -> {} // Scissors gets defeated by Rock
                }
            }
            case "B" -> {
                switch (myChoice) {
                    case "X" -> {} // Rock gets defeated by Paper
                    case "Y" -> finalScore += 3; // Tie
                    case "Z" -> finalScore += 6; // Scissors defeat Paper
                }
            }
            case "C" -> {
                switch (myChoice) {
                    case "X" -> finalScore += 6; // Rock defeats Scissors
                    case "Y" -> {} // Paper gets defeated by Scissors
                    case "Z" -> finalScore += 3; // Tie
                }
            }
        }
        return finalScore;
    }

    public int calculateScore2(String opponentChoice, String expectedOutcome) {
        int finalScore = 0;
        switch (expectedOutcome) {
            case "X" -> { // Lose
                switch (opponentChoice) {
                    case "A" -> finalScore += 3;
                    case "B" -> finalScore += 1;
                    case "C" -> finalScore += 2;
                }
            }
            case "Y" -> { // Draw
                finalScore = 3;
                switch (opponentChoice) {
                    case "A" -> finalScore += 1;
                    case "B" -> finalScore += 2;
                    case "C" -> finalScore += 3;
                }
            }
            case "Z" -> { // Win
                finalScore = 6;
                switch (opponentChoice) {
                    case "A" -> finalScore += 2;
                    case "B" -> finalScore += 3;
                    case "C" -> finalScore += 1;
                }
            }
        }
        return finalScore;
    }
}
