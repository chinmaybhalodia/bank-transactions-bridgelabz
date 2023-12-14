package com.example;

public class Customer extends Thread {
    private Bank bank;
    private int customerID;

    public Customer(Bank bank, int customerID) {
        this.bank = bank;
        this.customerID = customerID;
        this.bank.addCustomer(this.customerID);
    }

    @Override
    public void run() {
        // creating 5 transactions for this customer
        for (int i = 0; i < 5; i++) {
            double random = Math.random();
            int amount = (int) (Math.random() * 1000); // random amount to deposit or withdraw
            if (random > 0.5) {
                this.bank.deposit(this.customerID, amount);
            } else {
                this.bank.withdraw(this.customerID, amount);
            }

            // sleeping the thread for some random time
            try {
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
