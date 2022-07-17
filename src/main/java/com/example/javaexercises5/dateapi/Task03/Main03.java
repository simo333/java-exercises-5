package com.example.javaexercises5.dateapi.Task03;

public class Main03 {
    public static void main(String[] args) {
        MapTime.getMapTime().forEach((zone, localTime) -> System.out.println(zone + ": " + localTime));
    }
}
