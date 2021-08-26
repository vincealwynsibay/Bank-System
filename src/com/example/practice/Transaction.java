package com.example.practice;

public class Transaction {

	private String date;
	private double amount;

	public Transaction(String date, double amount) {
		this.date = date;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return getDate() + "\t|\t$" + getAmount();
	}
}
