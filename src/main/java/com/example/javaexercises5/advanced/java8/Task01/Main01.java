package com.example.javaexercises5.advanced.java8.Task01;

public class Main01 {
    public static void main(String[] args) {
        CheckinRange comparator = numbToCheck -> numbToCheck >= 0 && numbToCheck <= 100;

        boolean test = comparator.isInRange(30);
        boolean test2 = comparator.isInRange(300);
        System.out.println(test);
        System.out.println(test2);

    }
}
