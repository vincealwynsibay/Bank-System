package com.example.practice;

import java.util.Scanner;

public class UserInterface {
	private static Scanner scanner = new Scanner(System.in);

	// Main User Interface static Method to be used in the Bank Class
	public static Character main_user_interface() {
		System.out.println("\n========================================\n");
		System.out.println("WELCOME TO VINCE BANK (VB)");
		System.out.println("\n========================================\n");
		System.out.println("A. Login");
		System.out.println("B. Create Bank Account");
		System.out.println("C. Quit");
		System.out.print("> ");
		String input = scanner.next();
		System.out.println();
		System.out.println("\n========================================\n");
		return input.toUpperCase().charAt(0);
	}

	// Login static Method to be used in the Bank Class
	public static String login() {
		System.out.println("\n========================================");
		System.out.println("LOGIN (Enter Q to go back to the main interface)");
		System.out.println("========================================\n");
		System.out.print("Enter Name: ");
		String name = scanner.next();
		System.out.println("\n========================================\n");
//		return confirmation(name);
		return name;

	}

	// createBankAccount static Method to be used in the Bank Class
	public static Customer createBankAccount() {
		System.out.println("\n========================================");
		System.out.println("CREATE A BANK ACCOUNT\n");
		System.out.print("Enter Name: ");
		String name = scanner.next();
		System.out.print("\nEnter Occupation: ");
		String occupation = scanner.next();
		System.out.print("\nEnter Balance: ");
		double amount = scanner.nextDouble();
		System.out.println("\n========================================\n");

		Customer customer = new Customer(name, occupation, amount);
		return customer;
	}

	// bankFunction static Method to be used in the Bank Class
	public static Character bankFunction() {
		final char[] validInput = {'A', 'B', 'C', 'D'};
		System.out.println("\n========================================\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transactions");
		System.out.println("E. Logout");
		System.out.print("> ");
		String input = scanner.next().toUpperCase();
		System.out.println("\n========================================\n");
		char choice = input.charAt(0);
		if (true) {
			return choice;
		}
		return null;

	}
}
