package com.example.javaexercises5.functionalinterfaces.Task02;

/* Transform object of type S to object of type T */
@FunctionalInterface
public interface Transform<T, S> {

    T transform(S s);
}
