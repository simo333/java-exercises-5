package com.example.javaexercises5.stream.Task04;

import java.util.Arrays;
import java.util.List;

public class Task04 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaaaa", "bbbbbbbb", "ccc", "d", "eeeeeeee");

        list.stream()
                .forEach(s -> System.out.println(s.length()));

        List<String> result2 = list.stream()
                .sorted()
                .toList();
        System.out.println(result2);
        System.out.println();
        System.out.println();

        list.stream()
                .filter(s -> s.contains("c"))
                .forEach(System.out::println);

        int sum = list.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println(sum);

        List<String> result3 = list.stream()
                .sorted()
                .limit(3)
                .toList();
        System.out.println(result3);
    }
}
