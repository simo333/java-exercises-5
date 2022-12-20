package com.example.javaexercises5.designpattern.creational.factorymethod.second;

public class MySqlDriver implements DatabaseDriver {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL DB");
    }
}
