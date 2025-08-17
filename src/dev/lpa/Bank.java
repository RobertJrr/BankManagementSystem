package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//will hold list of accounts
//handle removing and adding accounts to the bank
public class Bank {
    List<Account> accounts;
    private final Scanner scanner = new Scanner(System.in);


    public Bank(){
        this.accounts = new ArrayList<>();
    }

    public void addNewAccount(){
        Account account;

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


        try{
            //wait 3 seconds before creating account
            Thread.sleep(3000);
            account = new Account(name,age,DOB,socialSec,0);
            this.accounts.add(account);
            System.out.println("Returning to main page...");
            //wait 2 seconds before returning to options menu
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();

        }

    }

}
