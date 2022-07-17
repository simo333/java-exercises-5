package com.example.javaexercises5.functionalinterfaces.Task02;


import com.example.javaexercises5.functionalinterfaces.Task01.Filter;

import java.util.Arrays;
import java.util.List;

public class Main02 {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,3,5,7,9,11,15,40,50,60,70);
        printList(ints, v -> v > 20, new IntegerTransform());
        System.out.println();
        System.out.println();
        printList(ints, v -> v > 20, new Transform<Integer, Integer>() {
            @Override
            public Integer transform(Integer integer) {
                return integer - 2;
            }
        });

        System.out.println();
        System.out.println();
        printList(ints, v -> v > 20, v -> v - 3);
    }

    static <T, S> void printList(List<S> src, Filter<S> f, Transform<T, S> t) {
        for (S s : src) {
            if (f.check(s)) {
                System.out.println(t.transform(s));
            }
        }
    }
}
