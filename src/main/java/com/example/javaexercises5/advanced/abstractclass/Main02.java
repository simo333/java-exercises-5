package com.example.javaexercises5.advanced.abstractclass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main02 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("z", "z"),
                new Person("b", "b"),
                new Person("f", "f"),
                new Person("x", "x"),
                new Person("y", "y")
        );

        Collections.sort(people);
        people.forEach(System.out::println);
    }

}
