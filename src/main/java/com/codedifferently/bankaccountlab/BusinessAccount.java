package com.codedifferently.bankaccountlab;

public class BusinessAccount extends BankAccount {

    private int taxId;

    public BusinessAccount(int taxId) {

        super();
        this.taxId = taxId;
    }

    public BusinessAccount(double fees, String name, double balance, int taxId) {
        super(fees, name, balance);
        this.taxId = taxId;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }
}
