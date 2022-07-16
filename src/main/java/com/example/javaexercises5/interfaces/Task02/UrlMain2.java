package com.example.javaexercises5.interfaces.Task02;

import com.example.javaexercises5.interfaces.Task01.Url;

public class UrlMain2 {
    public static void main(String[] args) {
        Url extendedUrl = new ExtendedUrl();
        System.out.println(extendedUrl.getParam("param1", "url_example/param1.55/param2.byte"));
    }
}