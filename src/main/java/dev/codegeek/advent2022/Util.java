package dev.codegeek.advent2022;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Util {
    public static Optional<List<String>> loadFile(String filename) {
        try {
            Path path = Paths.get(Objects.requireNonNull(Util.class.getClassLoader()
                    .getResource(filename)).toURI());

            List<String> lines = Files.readAllLines(path);
            return Optional.of(lines);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
