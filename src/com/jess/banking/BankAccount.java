package com.jess.banking;

/**
 * Created by Jess on 5/12/17.
 */
public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;
    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }
    // the branch arg is true is the customer is performing the transaction at a branch with a teller
    // the branch arg is false if the customer is performing the transation at an ATM
    public double deposit(double amount, boolean branch){
        balance += amount;
        return balance;
    }

    // the branch arg is true is the customer is performing the transaction at a branch with a teller
    // the branch arg is false if the customer is performing the transation at an ATM
    public double withdraw(double amount, boolean branch){
        if(amount > 500 && !branch){
            throw new IllegalArgumentException();
        }

        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking(){
        return accountType == CHECKING;
    }

    public boolean isSavings(){
        return accountType == SAVINGS;
    }

    // more methods that use firstName, lastName, and perform other functions


}
