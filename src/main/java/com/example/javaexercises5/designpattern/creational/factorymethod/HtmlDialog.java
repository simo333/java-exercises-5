package com.example.javaexercises5.designpattern.creational.factorymethod;

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
