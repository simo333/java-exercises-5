package com.example.javaexercises5.interfaces.Task03;

public interface Moveable {
    default void stop() {
        System.out.println("Default stop");
    }
    void start();
}
