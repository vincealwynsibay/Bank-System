package com.example.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	// ArrayList to store the list of bank accounts
	private ArrayList<BankAccount> bankAccounts;

	// boolean to check if the user has already logged in
	private static boolean isLogin = false;
	private BankAccount account = null;

	public Bank(ArrayList<BankAccount> bankAccounts) {
		this.bankAccounts = new ArrayList<>();
		this.bankAccounts = bankAccounts;

		// custom bank account for the admin
		Customer admin_customer = new Customer("admin", "admin", 1000);
		BankAccount admin_bank_account = new BankAccount(admin_customer);
		bankAccounts.add(admin_bank_account);
	}

	// Main Interface
	public void main_bank() {
		Character choice = UserInterface.main_user_interface();

		switch (choice) {
			case 'A':
				accessBankAccount();
				break;
			case 'B':
				create_bank_account();
				break;
			case 'C':
				System.out.println("Thank you for Coming, Come Again!");
				break;
			default:
				main_bank();
				break;
		}
	}


	// Access Bank Account
	private void accessBankAccount() {
		Scanner scanner = new Scanner(System.in);

		// If the user is not logged in yet, ask for their username
		while (!isLogin) {
			account = login();
		}

		// While the user is logged in, access all the bank account's functionalities
		while (isLogin) {
			// Static Method to ask the user some input
			Character choice = UserInterface.bankFunction();
			try {
				if (choice != null) {

					switch (choice) {
						case 'A':
							account.checkBalance();
							break;
						case 'B':
							System.out.print("Deposit Amount ($): ");
							double deposit_amount = scanner.nextDouble();
							account.deposit(deposit_amount);
							break;
						case 'C':
							System.out.print("Withdraw Amount ($): ");
							double withdraw_amount = scanner.nextDouble();
							account.withdraw(withdraw_amount);
							break;
						case 'D':
							account.previousTransactions();
							break;
						case 'E':
							isLogin = false;
							accessBankAccount();
							break;
						default:
							accessBankAccount();
							break;
					}
				}
			} catch (Exception e) {
				accessBankAccount();
			}


		}
	}

	// Method to login the user, if they are not logged in yet
	private BankAccount login() {
		String login = UserInterface.login();
		BankAccount account = null;

		if (login.equals("Q")) {
			main_bank();
		}



		for (int i = 0; i < this.bankAccounts.size(); i++) {
			BankAccount bankAccount = this.bankAccounts.get(i);
			// If the user has logged in already, there is no need to check their name
			if (!isLogin) {
				// Checks if the inputted name of the user is in the list already
				if (bankAccount.getCustomer().getName().toLowerCase().equals(login.toLowerCase())) {
					isLogin = true;
					account = bankAccount;
					return account;
				}
			}
		}
		login();
		return null;
	}

	// Method for creating a new bank account by making a customer object in a static method in the UserInterface Class
	private void create_bank_account() {

		try {
			Customer customer = UserInterface.createBankAccount();
			BankAccount bankAccount = new BankAccount(customer);
			this.bankAccounts.add(bankAccount);
			main_bank();
		} catch (Exception e) {
			create_bank_account();
		}


	}
}
