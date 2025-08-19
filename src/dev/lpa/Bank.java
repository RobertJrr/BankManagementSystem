package dev.lpa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//will hold list of accounts
//handle removing and adding accounts to the bank
public class Bank {
    private List<Account> accounts;
    private final Scanner scanner = new Scanner(System.in);
    private final Scanner fileScanner = new Scanner("bankinfo.txt");

    public Bank(){
        this.accounts = new ArrayList<>();

    }

//    print all accounts
    public void printAllAccounts(){
        for(Account account : accounts){
            System.out.println("[" + account + "]");
        }
    }

//    Delete account via social sec
    public void deleteAccount(){
        System.out.println("----Enter your social to DELETE your account----");
        Account account = getAccount();
        if(account == null){
            System.out.println("Account does not exist!");
            return;
        }
        accounts.remove(account);
    }

    //method to access user's account and withdraw and update
    public void accessAccount(){
        System.out.println("----Enter your social to ACCESS your account----");
        Account account = getAccount();
        if(account == null){
            System.out.println("Account does not exist!");
            return;
        }
        System.out.println("-Account accessed-");
        waitFewSeconds();
        updateAccount(account);

    }

//    get Account via social security number
    private Account getAccount(){
        String social = scanner.nextLine();
        for(Account account : accounts){
            if(account.getSocialSec().equals(social)){
                return account;
            }
        }
        return null;
    }

    //method to access user's account and withdraw and update
    private void updateAccount(Account account){
        int option = 0;
        do{
            printTitle();
            option = displayOptions();
            if(option == 1){
                withdraw(account);
            }else if(option == 2){
                deposit(account);
            }
        }while(option != 3);
        System.out.println("Logging out of account...Goodbye");
        waitFewSeconds();
    }

//    withdraw into account
    private void withdraw(Account account){
        System.out.println("Withdraw amount: ");
        double withdraw = scanner.nextDouble();
        scanner.nextLine(); //consume new line
        account.setBalance((account.getBalance() - withdraw));
    }
//    deposit into account
    private void deposit(Account account){
        System.out.println("Deposit amount: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine(); //consume new line
        account.setBalance((account.getBalance() + deposit));
    }

//    Create and add new Account by asking user for information
    public void addNewAccount(){
        //wait 3 seconds before creating account
        waitFewSeconds();
        Account account = createAccount();
        //add account
        this.accounts.add(account);
        storeToFile(account);
        System.out.println("Returning to main page...");
        //wait 2 seconds before returning to options menu
        waitFewSeconds();
    }

    //overloaded method to add account (for testing)
    public void addNewAccount(Account account){
        //wait 3 seconds before creating account
        waitFewSeconds();
        //add account
        this.accounts.add(account);
        storeToFile(account);
        System.out.println("Returning to main page...");
        //wait 2 seconds before returning to options menu
        waitFewSeconds();
    }


    //display options
    private int displayOptions(){
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Exit");
        System.out.println("Select Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    //Get information to create Account
    private Account createAccount(){
        // Try to put this in separate function maybe
        System.out.println("\n\n----Enter personal info----");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        //clear \n in buffer
        scanner.nextLine();
        System.out.print("DOB: ");
        String DOB = scanner.nextLine();
        System.out.print("Social Security: ");
        String socialSec = scanner.nextLine();
        System.out.print("Initial Deposit: ");
        int initialDeposit = scanner.nextInt();
        scanner.nextLine();
        return new Account(name,age,DOB,socialSec,initialDeposit);
    }


    //write to file when account is added
    private void storeToFile(Account account){
        try(FileWriter fileWriter = new FileWriter(("bankinfo.txt"),true)){

            fileWriter.write(account.toString() + "\n");
        }catch (IOException e){
           System.out.println(e.getMessage());
        }

    }

    //print title of bank
    public void printTitle(){
        String dashes = "-".repeat(10);
        System.out.println(dashes + "Chase Bank" + dashes);
    }
    //wait few seconds before executing
    private void waitFewSeconds(){
        try{
            Thread.sleep(1500);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
