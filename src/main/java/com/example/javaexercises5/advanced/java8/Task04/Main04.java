package com.example.javaexercises5.advanced.java8.Task04;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main04 {
    public static void main(String[] args) {

    }

    static <T> List<T> search(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream()
                .filter(predicate)
                .toList();
    }

    static <T, S> List<S> changeCollection(Collection<T> collection, Function<T, S> function) {
        return collection.stream()
                .map(function)
                .toList();
    }

    static <T> void consumeCollection(Collection<T> collection, Consumer<T> consumer) {
        collection.forEach(consumer);
    }

}
