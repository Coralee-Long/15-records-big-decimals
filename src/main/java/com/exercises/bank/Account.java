package com.exercises.bank;

import java.math.BigDecimal;

public class Account {
    private final String accountNumber;
    private BigDecimal accountBalance = new BigDecimal("0.00");;
    private final Client client;

    public Account(String accountNumber, BigDecimal accountBalance, Client client) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.client = client;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }


    // Add a method in Account to deposit and withdraw money:
    void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        System.out.println("account balance before: " + accountBalance);
        accountBalance = accountBalance.add(amount);
        System.out.println("deposit successful");
        System.out.println("account balance after: " + accountBalance);
    }
    void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (accountBalance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal.");
        }
        System.out.println("account balance before: " + accountBalance);
        accountBalance = accountBalance.subtract(amount);
        System.out.println("withdrawal successful");
        System.out.println("account balance after: " + accountBalance);
    }



    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", client=" + client +
                '}';
    }
}
