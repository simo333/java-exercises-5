package com.example.javaexercises5.abstractclass.Task01;

import java.util.List;

public class Main01 {
    public static void main(String[] args) {
        List<Vehicle> vehicles = List.of(
                new Car(260, "Audi", "SUV"),
                new Train(200, "Pendolino", 1435)
        );

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        Vehicle v1 = vehicles.get(0);
        Train t = (Train) v1;
    }
}
