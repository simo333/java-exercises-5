package com.example.javaexercises5.interfaces.Task01;

public class UrlMain {
    public static void main(String[] args) {
        Url url = new StandardUrl();
        System.out.println(url.getParam("param1", "url_example?param1=99&param2=string"));
    }
}
