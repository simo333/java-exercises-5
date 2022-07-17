package com.example.javaexercises5.stream.Task01;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Task01 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Artur", "Łukasz", "szymon", "Julia", "Marek",
                "Dorota", "Janusz", "Honorata", "Julia", "Marek", "Dorota");

        list.stream()
                .filter(s -> s.matches("[AaSs].*"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        List<String> result = list.stream()
                .distinct()
                .filter(s -> s.length() == 5)
                .toList();

        System.out.println(result);

        String resultString = list.stream()
                .sorted(Collator.getInstance(new Locale("pl", "PL")))
                .map(s -> s.substring(0, 3))
                .collect(Collectors.joining(", "));
        System.out.println(resultString);
    }
}
