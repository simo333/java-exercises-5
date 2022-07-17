package com.example.javaexercises5.functionalinterfaces.Task01;


import java.util.Arrays;
import java.util.List;

public class Main01 {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 5, 7, 23, 40, 6, 50, 10);
        printList(ints, new IntegerFilter());
        System.out.println();
        System.out.println();
        printList(ints, new Filter<>() {
            @Override
            public boolean check(Integer integer) {
                return integer < 20;
            }
        });
        System.out.println();
        System.out.println();
        printList(ints, integer -> integer < 20);
    }

    static <T> void printList(List<T> src, Filter<T> f) {
        for (T s : src) {
            if (f.check(s)) {
                System.out.println(s);
            }
        }
    }
}
