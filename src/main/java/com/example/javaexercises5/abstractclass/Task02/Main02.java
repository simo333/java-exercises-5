package com.example.javaexercises5.abstractclass.Task02;

import java.util.List;

public class Main02 {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
                new Rectangle(4, 5),
                new Square(7),
                new Circle(10)
        );

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
