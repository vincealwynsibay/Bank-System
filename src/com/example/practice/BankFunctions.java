package com.example.practice;

// interface to be used by the BankAccount class for its functionalities
public interface BankFunctions {

	void deposit(double amount);
	void withdraw(double amount);
	void checkBalance();
	void previousTransactions();
}
