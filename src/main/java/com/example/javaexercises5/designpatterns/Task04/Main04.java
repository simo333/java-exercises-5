package com.example.javaexercises5.designpatterns.Task04;

public class Main04 {
    public static void main(String[] args) {
        Post post = new Post();
        post.setTitle("Some title");
        post.setContent("Some content");

        post.attach(new FacebookObserver());
        post.attach(new TwitterObserver());
        post.share();
    }
}
