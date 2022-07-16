package com.example.javaexercises5.interfaces.Task03;

public class Person implements Moveable {
    @Override
    public void start() {
        System.out.println("Person – człowiek idzie");
    }

    @Override
    public void stop() {
        System.out.println("Person stop");
    }
}
