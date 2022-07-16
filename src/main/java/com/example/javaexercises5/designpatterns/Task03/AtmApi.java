package com.example.javaexercises5.designpatterns.Task03;

public class AtmApi {
    private BankAccount bankAccount;
    private Loan loan;
    private PhoneCard phoneCard;
    private Transfer transfer;

    public AtmApi() {
        this.bankAccount = new BankAccount();
        this.loan = new Loan();
        this.phoneCard = new PhoneCard();
        this.transfer = new Transfer();
    }

    public void depositMoney() {
        bankAccount.deposit();
    }

    public void withdrawMoney() {
        bankAccount.payOut();
    }

    public void loanMoney() {
        loan.getLoan();
    }

    public void rechargePhone() {
        phoneCard.recharge();
    }

    public void transferSomeMoney() {
        transfer.transferMoney();
    }
}
