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
            int totalScore = 0;
            for(String line : optionalLines.get()) {
                var choices = line.split(" ");
                totalScore += calculateScore(choices[0], choices[1]);
            }
            log.info("Total score: " + totalScore);
        } else {
            log.severe("Could not find file: " + filename);
        }
    }

    public int calculateScore(String opponentChoice, String myChoice) {
        int finalScore = shapeValue.get(myChoice);
        switch (opponentChoice) {
            case "A" -> {
                switch (myChoice) {
                    case "X": // Tie
                        finalScore += 3;
                        break;
                    case "Y": // Paper defeats Rock
                        finalScore += 6;
                        break;
                    case "Z": // Scissors gets defeated by Rock
                        break;
                }
            }
            case "B" -> {
                switch (myChoice) {
                    case "X": // Rock gets defeated by Paper
                        break;
                    case "Y": // Tie
                        finalScore += 3;
                        break;
                    case "Z": // Scissors defeat Paper
                        finalScore += 6;
                        break;
                }
            }
            case "C" -> {
                switch (myChoice) {
                    case "X": // Rock defeats Scissors
                        finalScore += 6;
                        break;
                    case "Y": // Paper gets defeated by Scissors
                        break;
                    case "Z": // Tie
                        finalScore += 3;
                        break;
                }
            }
        }
        return finalScore;
    }
}
