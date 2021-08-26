package com.example.practice;

public class Customer extends Person{
	private double balance;

	public Customer(String name, String occupation, double balance) {
		super(name, occupation);
		this.balance = balance;
	}

	protected double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	protected void changeBalance(double balance) {
		this.balance += balance;
	}
}
