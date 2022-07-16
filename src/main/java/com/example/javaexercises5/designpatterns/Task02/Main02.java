package com.example.javaexercises5.designpatterns.Task02;

import static com.example.javaexercises5.designpatterns.Task02.ProductType.*;

/* Classes meet the requirements of Fabric design pattern */
public class Main02 {
    public static void main(String[] args) {
        ProductCreator creator = new ProductCreator();
        Product simple = creator.getProductByType(SIMPLE);
        System.out.println(simple.getProductName());
        Product advanced = creator.getProductByType(ADVANCED);
        System.out.println(advanced.getProductName());
        Product virtual = creator.getProductByType(VIRTUAL);
        System.out.println(virtual.getProductName());
    }
}
