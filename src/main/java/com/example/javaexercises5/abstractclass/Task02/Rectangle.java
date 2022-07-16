package com.example.javaexercises5.abstractclass.Task02;

public class Rectangle extends Shape {
    private double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateArea() {
        return a * b;
    }

    @Override
    public double calculateCircuit() {
        return 2 * a + 2 * b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Prostokąt o bokach " + a + " i " + b + " - pole = " + calculateArea() + ", obwód = " + calculateCircuit();
    }
}
