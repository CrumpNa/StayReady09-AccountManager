package com.codedifferently.bankaccountlab;

public abstract class BankAccount {

    private int acctNum;
    private double fees;
    private String name;
    private double balance;

    public BankAccount(){
        this.acctNum = System.identityHashCode(this.acctNum);
        this.fees = 0;
        this.name = "Jane Doe";
        this.balance = 0.0;

    }

    public BankAccount(double fees, String name, double balance){

        this.acctNum = System.identityHashCode(this.acctNum);
        this.fees = fees;
        this.name = name;
        this.balance = balance;

    }

    public int getAcctNum() {
        return acctNum;
    }


    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
