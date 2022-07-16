package com.example.javaexercises5.designpatterns.Task04;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Post implements Subject {
    private List<Observer> observers;
    private String content;
    private String title;

    public Post() {
        this.observers = new ArrayList<>();
    }

    public void share() {
        System.out.println("UPDATE OBSERVERS");
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        System.out.println("New observer added: " + observer.getClass().getSimpleName());
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        System.out.println("Observer removed: " + observer.getClass().getSimpleName());
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            System.out.println("NEW NOTIFY for " + observer.getClass().getSimpleName());
            observer.update(title);
        }
    }
}
