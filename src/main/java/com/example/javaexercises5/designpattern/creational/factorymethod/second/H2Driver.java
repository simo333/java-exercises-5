package com.example.javaexercises5.designpattern.creational.factorymethod.second;

public class H2Driver implements DatabaseDriver {
    @Override
    public void connect() {
        System.out.println("Connecting to H2 DB");
    }
}
