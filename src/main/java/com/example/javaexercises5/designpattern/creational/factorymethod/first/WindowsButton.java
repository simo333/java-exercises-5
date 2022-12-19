package com.example.javaexercises5.designpattern.creational.factorymethod.first;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("<WindowsButton>");
    }

    @Override
    public void onClick() {
        System.out.println("Windows button has been clicked!");
    }
}
