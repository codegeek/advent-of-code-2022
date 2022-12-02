package dev.codegeek.advent2022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class Day1 {
    private static final Logger log = Logger.getLogger("Day1");

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        day1.processFile("day1/input");
    }

    public record Elf(List<Integer> calories) {
        public Integer totalCalories() {
            return calories.stream().mapToInt(Integer::intValue).sum();
        }
    }

    public void processFile(String filename) {
        var optionalLines = Util.loadFile(filename);
        if (optionalLines.isPresent()) {
            var lines = optionalLines.get();

            final var elves = new HashSet<Elf>();
            var elfCalories = new ArrayList<Integer>();
            for (String line : lines) {
                try {
                    elfCalories.add(Integer.parseInt(line));
                } catch (NumberFormatException nfe) {
                    elves.add(new Elf(elfCalories));
                    elfCalories = new ArrayList<>();
                }
            }

            log.info("Max Calories: " + calculateScore1(elves));
            log.info("Top three calories (sum): " + calculateScore2(elves));
        } else {
            log.severe("Could not find file: " + filename);
        }
    }

    public int calculateScore1(Set<Elf> elves) {
        return sortElves(elves).get(0).totalCalories();
    }

    public int calculateScore2(Set<Elf> elves) {
        return sortElves(elves).stream().limit(3).mapToInt(Elf::totalCalories).sum();
    }

    private List<Elf> sortElves(Set<Elf> elves) {
        return elves.stream().sorted(Comparator.comparing(Elf::totalCalories).reversed()).toList();
    }
}
