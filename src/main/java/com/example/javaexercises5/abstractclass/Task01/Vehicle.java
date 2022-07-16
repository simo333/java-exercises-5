package com.example.javaexercises5.abstractclass.Task01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Vehicle {
    private Integer maxSpeed;
    protected String model;

    public abstract String getSound();

    @Override
    public String toString() {
        return "Class: " + getClass().getSimpleName() +
                ", model: " + getModel() +
                ", speed: " + getMaxSpeed() +
                ", sound: " + getSound();
    }
}