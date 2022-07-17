package com.example.javaexercises5.lambda.Task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        String word;

        while(!(word = scan.nextLine()).isEmpty()) {
            words.add(word);
        }

        words.sort((w1, w2) -> w1.compareToIgnoreCase(w2));

        System.out.println(words);
    }
}
