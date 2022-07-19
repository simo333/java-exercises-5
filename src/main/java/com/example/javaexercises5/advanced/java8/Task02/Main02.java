package com.example.javaexercises5.advanced.java8.Task02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main02 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("tree", "bird", "park", "snow", "computer", "i jeszcze jakiś inny napis, który na końcu ma a");

        List<String> strings1 = filterList(list, s -> s.length() > 4);
        List<String> strings2 = filterList(list, s -> s.startsWith("b"));
        List<String> strings3 = filterList(list, s -> s.endsWith("a"));

        System.out.println(strings1);
        System.out.println(strings2);
        System.out.println(strings3);
    }

    static List<String> filterList(List<String> src, Predicate<String> filter) {
        return src.stream()
                .filter(filter)
                .toList();
    }
}
