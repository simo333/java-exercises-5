package com.example.javaexercises5.advanced.java8.Task06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main06 {
    public static void main(String[] args) {
        Path path = Paths.get("earnings.txt");
        try {
            List<String> strings = Files.readAllLines(path);
            strings.stream()
                    .filter(s -> s.contains(";"))
                    .filter(s -> s.matches("[^Kowalsk]"))
                    .sorted()
                    .limit(3)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Cannot read file.");
        }
    }
}
