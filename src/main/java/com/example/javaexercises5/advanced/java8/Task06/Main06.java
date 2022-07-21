package com.example.javaexercises5.advanced.java8.Task06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main06 {
    public static void main(String[] args) {
        Path path = Paths.get("earnings.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines
                    .filter(e -> !e.matches(".*Kowalsk.*"))
                    .map(e -> e.split(",|;"))
                    .filter(e -> e.length > 2)
                    .filter(e -> e[2].length() > 1)
                    .peek(e -> e[2] = e[2].substring(0, e[2].length() - 3))
                    .sorted((e1, e2) -> Double.compare(Double.parseDouble(e2[2]), Double.parseDouble(e1[2])))
                    .limit(3)
                    .forEach(e -> System.out.println(e[0] + " " + e[1] + " -" + e[2]));

        } catch (IOException e) {
            System.out.println("Cannot read file.");
        }
    }
}
