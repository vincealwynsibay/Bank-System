package com.example.practice;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // List of Existing Accounts
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        // Creating the Bank Class
        Bank bank = new Bank(bankAccounts);

        // Using the bank Object's main_bank functionalities
        bank.main_bank();
    }
}
