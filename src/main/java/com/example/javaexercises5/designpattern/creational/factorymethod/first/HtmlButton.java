package com.example.javaexercises5.designpattern.creational.factorymethod.first;

public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button>Test button</button>");
    }

    @Override
    public void onClick() {
        System.out.println("Html button clicked!");
    }
}
