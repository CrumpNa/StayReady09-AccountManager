package com.codedifferently.bankaccountlab;

import java.util.HashMap;

public class BankUser {
    private int memId;
    private String userName = "";
    private String pass = "";
    private HashMap<Integer,BankAccount> accts;

    public BankUser(String userName, String pass) {

        memId = System.identityHashCode(this.memId);
        this.userName = userName;
        this.pass = pass;
        accts = new HashMap<>();
    }

    public BankAccount getAcct(int acctNum) {

        return accts.get(acctNum);
    }

    public void addToAcctsList(BankAccount temp) {

        accts.put(temp.getAcctNum(), temp);

        System.out.println("Your acct num is: " + temp.getAcctNum() + " remember it because you will need it!!!!");
    }
    public HashMap<Integer,BankAccount> getAccts() {

        return accts;
    }


    public int getMemId() {
        return memId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}


