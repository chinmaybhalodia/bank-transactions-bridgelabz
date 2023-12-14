package com.example;

import java.util.HashMap;

public class Bank {
    private HashMap<Integer, Integer> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    // method to deposit amount to customer account
    public synchronized void deposit(int customerID, int amount) {
        if (accounts.containsKey(customerID)) {
            int balance = accounts.get(customerID);
            if (amount < 0) {
                System.out.println("Amount cannot be negative.");
                return;
            }
            balance += amount;
            accounts.put(customerID, balance);
            System.out.println("Deposited amount: " + amount + " from customer: " + customerID);
        } else {
            System.out.println("Customer not registered with bank.");
        }
    }

    // method to withdwar amount from customer account
    public synchronized void withdraw(int customerID, int amount) {
        if (accounts.containsKey(customerID)) {
            int balance = accounts.get(customerID);
            if (amount > balance) {
                System.out.println("Insufficient balance for customer: " + customerID);
                return;
            } else if (amount < 0) {
                System.out.println("Amount cannot be negative.");
                return;
            }
            balance -= amount;
            accounts.put(customerID, balance);
            System.out.println("Withdrew amount: " + amount + " from customer: " + customerID);
        } else {
            System.out.println("Customer not registered with bank.");
        }
    }

    // method to get balance of the customer
    public synchronized int getBalance(int customerID) {
        if (accounts.containsKey(customerID)) {
            return accounts.get(customerID);
        } else {
            System.out.println("Customer not registered with bank.");
            return Integer.MIN_VALUE;
        }
    }

    // method to add new customer
    public synchronized void addCustomer(int customerID) {
        accounts.put(customerID, 0);
    }
}
