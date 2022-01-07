package com.example.User.Model;

public class Action {
    private String id;
    private String password;
    private double balance;
    private int amount;

    public Action(String id, String password, double balance, int amount) {
        this.id = id;
        this.password = password;
        this.balance = balance;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}