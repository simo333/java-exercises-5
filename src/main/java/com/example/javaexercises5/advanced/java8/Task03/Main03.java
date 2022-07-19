package com.example.javaexercises5.advanced.java8.Task03;

import java.util.function.Function;

public class Main03 {
    public static void main(String[] args) {
        Function<String, String> transformTxt = s -> (s.substring(2, s.length() - 2)).toLowerCase();
        System.out.println(transformTxt.apply("CODERSLAB"));
    }
}
