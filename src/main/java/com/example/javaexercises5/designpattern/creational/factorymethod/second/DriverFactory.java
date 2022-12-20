package com.example.javaexercises5.designpattern.creational.factorymethod.second;

public class DriverFactory {
    
    public DatabaseDriver getDriver(String url) {
        if(url.contains("h2")) {
            return new H2Driver();
        } else if (url.contains("mysql")) {
            return new MySqlDriver();
        }
        throw new IllegalStateException("No such DB driver found.");
    }

}
