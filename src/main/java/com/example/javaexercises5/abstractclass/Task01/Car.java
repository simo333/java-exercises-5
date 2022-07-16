package com.example.javaexercises5.abstractclass.Task01;

public class Car extends Vehicle {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car(Integer maxSpeed, String model, String type) {
        super(maxSpeed, model);
        this.type = type;
    }

    @Override
    public String getSound() {
        return "bruuumum";
    }
}
