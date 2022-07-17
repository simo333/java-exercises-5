package com.example.javaexercises5.lambda.Task02;


import com.example.javaexercises5.lambda.Test.Book;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main02 {
    public static void main(String[] args) {
        Predicate<Object> isString = o -> o instanceof String;
        Predicate<Object> ifStringThenSout = o -> {
            if (o instanceof String) {
                System.out.println(o);
                return true;
            }
            return false;
        };
        List<Object> objects = Arrays.asList(1, 2.0, "String", 'c', new Book(1, "t"), "String2");
        for (Object object : objects) {
            if (isString.test(object)) {
                System.out.println(object);
            }
        }

        for (Object object : objects) {
            ifStringThenSout.test(object);
        }
    }
}
