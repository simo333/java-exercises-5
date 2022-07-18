package com.example.javaexercises5.advanced.abstractclass;


import java.util.Arrays;
import java.util.List;

public class Main04 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new Employee(),
                new Employee(),
                new Company(),
                new Company()
        );

        for (User user : users) {
            if(user instanceof Payable payable) {
                payable.pay();
            }
        }
    }
}
