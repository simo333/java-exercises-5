package com.example.javaexercises5.abstractclass.Task02;

public class Square extends Shape {
    private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double calculateArea() {
        return a * a;
    }

    @Override
    public double calculateCircuit() {
        return 4 * a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Kwadrat o boku " + a + " - pole = " + calculateArea() + ", obwód = " + calculateCircuit();
    }
}
