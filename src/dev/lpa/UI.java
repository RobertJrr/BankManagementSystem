package dev.lpa;

import java.io.File;
import java.io.InterruptedIOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class UI {
    Bank chase;
    private final Scanner scanner = new Scanner(System.in);

    //    constructor
    public UI(){
        chase = new Bank();
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
            if(option == 1){

            }else if(option == 2){

            }else if(option == 3){
                chase.addNewAccount();
            }else if(option == 4){

            }else if(option == 5){

            }
        }while(option != 5);

    }

    //need to create another option for this
    private static void getAccount(){
        printTitle();
        System.out.println("Enter social to access your account...");
    }

    private static void printTitle(){
        String dashes = "-".repeat(10);
        System.out.println(dashes + "Chase Bank" + dashes);
    }

    private static void displayChoices(){
        printTitle();
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
                System.out.println("File exists: Using " + file.getName() + " to store info");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
