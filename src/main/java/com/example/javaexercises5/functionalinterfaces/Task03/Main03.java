package com.example.javaexercises5.functionalinterfaces.Task03;

import com.example.javaexercises5.functionalinterfaces.Task01.Filter;
import com.example.javaexercises5.functionalinterfaces.Task02.Transform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main03 {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 3, 5, 9, 10, 20, 30, 40, 50, 70);
        System.out.println(create(ints, v -> v > 20, Integer::doubleValue));
    }

    static <T, S> List<T> create(List<S> src, Filter<S> f, Transform<T, S> t) {
        List<T> result = new ArrayList<>();
        for (S s : src) {
            if (f.check(s)) {
                result.add(t.transform(s));
            }
        }
        return result;
    }
}
