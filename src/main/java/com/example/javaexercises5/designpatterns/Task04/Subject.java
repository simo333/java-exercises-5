package com.example.javaexercises5.designpatterns.Task04;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
