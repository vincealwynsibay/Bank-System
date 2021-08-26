package com.example.practice;

import java.text.SimpleDateFormat;
import java.util.*;

public class BankAccount implements BankFunctions {
	private Customer customer;

	private HashMap<Integer, Transaction> transactions;
	private ArrayList<HashMap> previousTransactions;

	private double fare = 0.10;
	private static Date date;

	// Constructor for the Bank Account
	// needs a Customer Object to make a bank account
	public BankAccount(Customer customer) {
		this.customer = customer;
		this.transactions = new HashMap<Integer, Transaction>();
		this.previousTransactions = new ArrayList<>();

		this.date = new Date();

		this.previousTransactions.add(transactions);
	}

	// Deposits and adds the transaction to the previous transactions arraylist
	@Override
	public void deposit(double amount) {
		if (amount > 0) {
			customer.setBalance(customer.getBalance() + amount);
			Transaction deposit_transaction = new Transaction(getDate(), amount);
			this.transactions.put(this.transactions.size()+1, deposit_transaction);
			System.out.println("You deposited $" + amount + ".");
		} else {
			System.out.println("Please Try Again.");
		}
	}

	// Withdraws and adds the transaction to the previous transactions arraylist
	@Override
	public void withdraw(double amount) {
		if (amount > 0 && amount <= customer.getBalance()) {
			customer.setBalance(customer.getBalance() + -(amount+fare));
			Transaction withdraw_transaction = new Transaction(getDate(), -(amount+fare));
			this.transactions.put(this.transactions.size()+1, withdraw_transaction);
			System.out.println("You withdrawn $" + amount + ".");
		} else {
			System.out.println("Please Try Again.");
		}
	}

	// Checking Balance
	@Override
	public void checkBalance() {
		System.out.println("Current Balance: " + customer.getBalance());
	}


	// Printing the contents of the previousTransactions ArrayList in a tablesque format
	@Override
	public void previousTransactions() {
		System.out.println("\nPrevious Transactions\n");
		System.out.println("\t\tDate\t\t|\tTransaction Amount\n");
		for (int i = 1; i < this.transactions.size() + 1; i++) {
			Transaction name = (Transaction) this.previousTransactions.get(0).get(i);
			System.out.println(name.toString());
		}
		System.out.println();
	}

	// private class to be used then adding the transactions
	private String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatter.format(this.date);
	}

	public Customer getCustomer() {
		return customer;
	}

}
