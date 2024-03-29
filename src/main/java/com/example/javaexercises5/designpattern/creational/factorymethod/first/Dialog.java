package com.example.javaexercises5.designpattern.creational.factorymethod.first;

public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
