package com.example.javaexercises5.lambda.Task03;


import com.example.javaexercises5.lambda.Test.Book;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main03 {
    public static void main(String[] args) {
        Predicate<Object> isNumber = o -> o instanceof Number;
        Predicate<Object> ifNumberThenSout = o -> {
            if (o instanceof Number) {
                System.out.println(o);
                return true;
            }
            return false;
        };
        List<Object> objects = Arrays.asList(1, 2.0, "String", 'c', new Book(1, "t"), "String2");
        for (Object object : objects) {
            if (isNumber.test(object)) {
                System.out.println(object);
            }
        }

        for (Object object : objects) {
            ifNumberThenSout.test(object);
        }
    }
}
