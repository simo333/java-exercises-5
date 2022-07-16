package com.example.javaexercises5.designpatterns.Task04;

public class FacebookObserver implements Observer {
    @Override
    public void update(String title) {
        System.out.println("Facebook: " + title);
    }
}
