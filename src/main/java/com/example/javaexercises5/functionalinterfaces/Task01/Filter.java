package com.example.javaexercises5.functionalinterfaces.Task01;

@FunctionalInterface
public interface Filter<V> {
    boolean check(V v);
}
