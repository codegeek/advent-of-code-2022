package dev.codegeek.advent2022;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Day1 {
    private static final Logger log = Logger.getLogger("Day1");

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        day1.processFile("day1/input");
    }

    public void processFile(String filename) {
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(filename)).toURI());

            List<String> lines = Files.readAllLines(path);

            int sumCalories = 0;
            int maxCalories = 0;
            for (String line : lines) {
                try {
                    int calories = Integer.parseInt(line);
                    sumCalories += calories;
                } catch (NumberFormatException nfe) {
                    maxCalories = Math.max(sumCalories, maxCalories);
                    sumCalories = 0;
                }
            }
            log.info("Max Calories: " + maxCalories);
        } catch (Exception e) {
            log.severe("Could not find file: " + filename);
            throw new RuntimeException(e);
        }
    }
}
