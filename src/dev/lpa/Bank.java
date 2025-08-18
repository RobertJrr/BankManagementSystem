package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//will hold list of accounts
//handle removing and adding accounts to the bank
public class Bank {
    private List<Account> accounts;
    private final Scanner scanner = new Scanner(System.in);


    public Bank(){
        this.accounts = new ArrayList<>();
    }
    //method to access user's account and withdraw and update
    public void accessAccount(){
        System.out.println("----Enter your social to access your account----");
        Account account = getAccount();
        if(account == null){
            System.out.println("Account does not exist!");
            return;
        }
        System.out.println("-Account accessed-");
        waitFewSeconds();
        updateAccount(account);

    }

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

    private void withdraw(Account account){
        System.out.println("Withdraw amount: ");
        double withdraw = scanner.nextDouble();
        scanner.nextLine(); //consume new line
        account.setBalance((account.getBalance() - withdraw));
    }
    private void deposit(Account account){
        System.out.println("Deposit amount: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine(); //consume new line
        account.setBalance((account.getBalance() + deposit));
    }

    public void addNewAccount(){

        //wait 3 seconds before creating account
        waitFewSeconds();
        Account account = createAccount();
        //add account
        this.accounts.add(account);
        System.out.println("Returning to main page...");
        //wait 2 seconds before returning to options menu
        waitFewSeconds();

    }


    private int displayOptions(){
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Exit");
        System.out.println("Select Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

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

    public void printTitle(){
        String dashes = "-".repeat(10);
        System.out.println(dashes + "Chase Bank" + dashes);
    }
    private void waitFewSeconds(){
        try{
            Thread.sleep(1500);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
