package com.example.javaexercises5.stream.Task03;

import java.util.Arrays;
import java.util.List;

public class Task03 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = numbers.stream()
                .filter(n -> n < 20)
                .map(n -> n * n - 5)
                .toList();
        System.out.println(result);
    }
}
