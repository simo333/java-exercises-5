package com.example.javaexercises5.interfaces.Task03;

import java.util.List;

public class Main01 {
    public static void main(String[] args) {
        List<Moveable> moveables = List.of(
                new Cat(),
                new Car(),
                new Person()
        );
        for (Moveable moveable : moveables) {
            moveable.start();
            moveable.stop();
        }
    }
}
