package com.example.javaexercises5.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Task03 {
    public static void main(String[] args) {
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(), Optional.of("java"), Optional.empty(), Optional.of("python"), Optional.of("php"), Optional.empty(), Optional.of(""));

        listOfOptionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}
