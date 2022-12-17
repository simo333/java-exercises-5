package com.example.javaexercises5.designpattern.creational.factorymethod;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
