package com.example;

public class Main {
    public static void main(String[] args) {
        // creating new bank
        Bank bank = new Bank();

        // simulating 5 customers
        for (int i = 1; i <= 5; i++) {
            Customer customer = new Customer(bank, i);
            customer.start();
        }

        // waiting until all customer threads are executed
        for (Thread customer : Thread.getAllStackTraces().keySet()) {
            // joining every thread of customer class
            if (customer instanceof Customer) {
                try {
                    customer.join();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }

        // printing final balances of all customers
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Balance for customer " + i + " is: " + bank.getBalance(i));
        }
    }
}