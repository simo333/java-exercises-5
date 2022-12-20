package com.example.javaexercises5.designpattern.creational.factorymethod.second;

public class App {
    public static void main(String[] args) {
        DriverFactory driverFactory = new DriverFactory();
        DatabaseDriver driver = driverFactory.getDriver("h2");
        driver.connect();
    }
}
