package com.example.User.Model;

public class BankUser {

    private String id;
    private String name;
    private String password;
    private String email;
    private Double balance ;
    private double lonAmount ;


    public BankUser(String id, String name, String password, String email, Double balance, double lonAmount) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.lonAmount = lonAmount;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public double getLonAmount() {
        return lonAmount;
    }

    public void setLonAmount(double lonAmount) {
        this.lonAmount = lonAmount;
    }
}
