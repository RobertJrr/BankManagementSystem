package dev.lpa;

import java.io.File;
import java.io.InterruptedIOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class UI {
    private final Scanner scanner = new Scanner(System.in);

    //    constructor
    public UI(){

    }
    public void begin(){
        createFile();

        int option = 0;
        do{
            displayChoices();
            option = scanner.nextInt();
            //clear buffer
            scanner.nextLine();
//            Create Account
            if(option == 3){
                makeAccount();
            }
        }while(option != 5);

    }


    //create person prompt
    private void makeAccount(){
        Account account;

//        Try to put this in separate function maybe
        System.out.println("\n\n----Enter person information, this will be used to create an account----");
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

//        waiting 3 seconds then attempt to create Person
        //maybe put this in method (LEFT OFF HERE)
        try{
            System.out.println("Creating person...");
            Thread.sleep(3000);
            account = new Account(name,age,DOB,socialSec,0);
            System.out.println("Returning to main page...");
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();

        }

    }

    private static void displayChoices(){
        String dashes = "-".repeat(10);
        System.out.println(dashes + "Chase Bank" + dashes);
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.Create New Account");
        System.out.println("4.Delete Account");
        System.out.println("5. Exit");
        System.out.print("Enter choice --> ");
    }
    //create a file to store users data(practice for jdbc)
    private static void createFile(){
        File file = new File("bankinfo2.txt");
        try{
            if(file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }else{
                System.out.println("File exists: Using " + file.getName());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
