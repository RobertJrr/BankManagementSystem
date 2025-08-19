package dev.lpa;

import java.io.File;
import java.util.Scanner;


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
                chase.accessAccount();
            }else if(option == 2){
                chase.addNewAccount();
            }else if(option == 3){
                chase.deleteAccount();
            }
        }while(option != 4);

    }

    private  void displayChoices(){
        chase.printTitle();
        System.out.println("1.Access Account");
        System.out.println("2.Create New Account");
        System.out.println("3.Delete Account");
        System.out.println("4. Exit");
        System.out.print("Enter choice --> ");
    }

    //create a file to store users data(practice for jdbc)
    private static void createFile(){
        File file = new File("bankinfo.txt");
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
