package com.example.javaexercises5.designpatterns.Task03;

public class BankAccount {
    public void deposit(){
        System.out.println(getClass().getSimpleName() + ": deposited");
    }
    public void payOut(){
        System.out.println(getClass().getSimpleName() + ": payed out");
    }
}
