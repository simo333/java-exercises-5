package com.example.javaexercises5.abstractclass.Task02;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2) ;
    }

    @Override
    public double calculateCircuit() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Koło o promieniu " + radius + " - pole = " + calculateArea() + ", obwód = " + calculateCircuit();
    }
}
