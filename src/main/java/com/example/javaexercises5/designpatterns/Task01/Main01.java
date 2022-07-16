package com.example.javaexercises5.designpatterns.Task01;

public class Main01 {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        System.out.println(appConfig.getHost());
        appConfig.setHost("instance-2");
        System.out.println(appConfig.getHost());
        System.out.println(AppConfig.getInstance().getHost());

        AppConfig appConfig2 = AppConfig.getInstance();
        appConfig2.setHost("instance-3");
        System.out.println(appConfig.getHost());
    }
}
