package com.codedifferently.bankaccountlab;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MainApplication {

    HashMap<Integer,BankUser> members;
    BankUser currentUser;
    private String name;
    private double fees;
    private double balance;
    private int taxId;
    private int choice;

    public static void main(String [] args){
        MainApplication temp = new MainApplication();
        temp.login();

    }

    public MainApplication(){

        members = new HashMap<>();
    }

    public  void login() {

        System.out.println("1) login 2) Become member");
        int sel = (int) input();
        switch (sel) {
            case 1:
                System.out.println("Enter MemId: ");
                int id = (int) input();
                currentUser = members.get(id);
                System.out.println("Enter username: ");
                String uName = strInput();
                System.out.println("Enter password: ");
                String password = strInput();
                if(!(currentUser.getUserName().equals(uName) && currentUser.getPass().equals(password))) {
                    login();
                } else {

                    atm();
                }


                break;

            case 2:
                addBankUserToBank();
                login();
                break;

        }


    }

    public void atm(){

        System.out.println("Welcome please enter chocie: 1) Create 2) view 3) Delete");
        choice = (int) input();
        switch (choice) {
            case 1:
                createSwitch();
                atm();
                break;

            case 2:

                veiw();
                atm();
                break;

            case 3:
                delete();
                atm();
                break;

            default:
                System.out.println("Option not found!");
                atm();

        }

    }


    private void veiw() {

        System.out.println("Enter acct num to view acct: ");
        int acctNum = 0;
        try {

             acctNum = (int) input();
             System.out.println("Your current account balance is: " + currentUser.getAcct(acctNum).getBalance());
        } catch (NullPointerException e) {

            System.out.println("You can not view an acct you dont have!! Back to main menu.");
            atm();
        }


    }

    private void createCheckings() {

        setFees(50);
        System.out.println("Enter Name: ");
        setName(strInput());
        System.out.println("Enter init deposit Amt: ");
        setBalance(input());
    }

    private void createSavings() {

        setFees(5);
        System.out.println("Enter Name: ");
        setName(strInput());
        System.out.println("Enter init deposit Amt: ");
        setBalance(input());
    }

    private void createBusiness() {

        setFees(1000);
        System.out.println("Enter Company Name: ");
        setName(strInput());
        System.out.println("Enter init deposit Amt: ");
        setBalance(input());
        System.out.println("Enter Tax Id: ");
        setTaxId((int) input());
    }

    private void createSwitch(){

        BankAccount newAcct;
        System.out.println("What type of Acct? 1) Checking 2) Savings 3) Business");
        choice = (int) input();
        switch (choice) {

            case 1:
                createCheckings();
                newAcct = new CheckingAccount(getFees(), getName(), getBalance());
                currentUser.addToAcctsList(newAcct);
                break;

            case 2:

                createSavings();
                newAcct = new SavingsAccount(getFees(), getName(), getBalance());
                currentUser.addToAcctsList(newAcct);
                break;

            case 3:

                createBusiness();
                newAcct = new BusinessAccount(getFees(), getName(), getBalance(), getTaxId());
                currentUser.addToAcctsList(newAcct);
                break;

            default:
                System.out.println("Option not found!");
                atm();

        }

    }




    private void delete() {

        System.out.println("Enter acct num to delete acct: ");

        int acctNum = (int) input();
        try {
            System.out.println("Account " + currentUser.getAcct(acctNum).getAcctNum() + " has been erased!");
            currentUser.getAccts().remove(acctNum);

        } catch(NullPointerException e) {

            System.out.println("You're trying to delete an account that doesn't exist");
            atm();

        }

    }

    private String strInput(){

        String input;
        Scanner in = new Scanner(System.in);
        input = in.next();


        return input;
    }

    private double input() {

        double input = 0;
        Scanner in = new Scanner(System.in);

        try{

            input = in.nextDouble();
        } catch(InputMismatchException e) {

            System.out.println("Invaild input, back to main menu!!");
            atm();
        }

        return input;
    }

    private void addBankUserToBank(){

        BankUser newUser = createBankUser();
        members.put(newUser.getMemId(), newUser);
    }

    private BankUser createBankUser(){

        System.out.println("Welcome to the atm new member!!");
        System.out.println("Enter Username: ");
        String uName = strInput();
        System.out.println("Enter password: ");
        String password = strInput();
        BankUser newUser = new BankUser(uName, password);
        System.out.println("Your memId is: " + newUser.getMemId() + "\n Remember it!!" );

        return newUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }


}
