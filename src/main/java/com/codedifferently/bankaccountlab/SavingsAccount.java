package com.codedifferently.bankaccountlab;

public class SavingsAccount extends BankAccount {

    private double rate;

    public SavingsAccount() {
        super();
        this.rate = 10;
    }

    public SavingsAccount(double fees, String name, double balance) {
        super(fees, name, balance);
        setRate(balance);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double bal) {

        this.rate = bal/365;
    }
}
