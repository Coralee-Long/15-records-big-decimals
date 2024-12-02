package com.exercises.bank;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Account account1 = new Account("850284", BigDecimal.valueOf(4399.98), new Client("John", "Doe", "C12345"));
        Account account2 = new Account("936472", BigDecimal.valueOf(9746.36), new Client("Jane", "Smith", "C67890"));
        Account account3 = new Account("937485", BigDecimal.valueOf(453.99), new Client("Emily", "Jones", "C98765"));

        System.out.println(account1 + "\n" + account2 + "\n" + account3);

        // Deposit Money
        account1.deposit(BigDecimal.valueOf(500.00));

        // Withdrawal
        account2.withdraw(BigDecimal.valueOf(300.00)); // success

        // Attempt invalid withdrawal
        try {
            account3.withdraw(BigDecimal.valueOf(2000.00)); // Insufficient funds
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Output: Error: Insufficient balance for withdrawal.
        }
    }
}
