package com.example.javaexercises5.designpatterns.Task03;

public class Main03 {
    public static void main(String[] args) {
        AtmApi atmApi = new AtmApi();
        atmApi.depositMoney();
        atmApi.withdrawMoney();
        atmApi.loanMoney();
        atmApi.rechargePhone();
        atmApi.transferSomeMoney();
    }
}
