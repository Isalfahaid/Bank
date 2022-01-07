package com.example.User.Model;

public class BankUser {

    private String id;
    private String name;
    private String password;
    private String email;
    private double balance ;
    private double lonAmount  ;


    public BankUser(String id, String name, String password, String email, double balance, double lonAmount) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.balance = 0.0;
        this.lonAmount = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLonAmount() {
        return lonAmount;
    }

    public void setLonAmount(double lonAmount) {
        this.lonAmount = lonAmount;
    }
}
