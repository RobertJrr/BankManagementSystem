package dev.lpa;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private long accountNumber;
    private long routingNumber;
    private double balance;

    private String name;
    private int age;
    private String DOB;
    private String socialSec;

    public Account(String name, int age, String DOB, String socialSec,int initialDeposit){

        if(validDOB(DOB) && validSocialSec(socialSec)){
            this.DOB = DOB;
            this.socialSec = socialSec;
            this.name = name;
            this.age = age;
            generateAccountAndRoutingNumber();
            System.out.println("Account created for " + this.name);
        } else{
            System.out.println("Invalid information, cannot create");
        }
    }

    private static boolean validDOB(String DOB){
        Pattern pattern = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
        Matcher matcher = pattern.matcher(DOB);
        return matcher.matches();
    }

    private static boolean validSocialSec(String socialSec){
        Pattern pattern = Pattern.compile("[0-9]{3}-[0-9]{2}-[0-9]{4}");
        Matcher matcher = pattern.matcher(socialSec);
        return matcher.matches();
    }

    private void generateAccountAndRoutingNumber(){
        //prefixes for account and routing number
        String routingNum = "32222";
        String accountNum = "7171";
        //random num for routing number
        String generateNumber = String.valueOf(new Random().nextInt(1000,100000));
        routingNum += generateNumber;
        this.routingNumber = Long.parseLong(routingNum);

//        routing num for account number
        generateNumber = String.valueOf(new Random().nextInt(1000,100000));
        accountNum += generateNumber;
        this.accountNumber = Long.parseLong(accountNum);
    }

    @Override
    public String toString(){
        return ("Name: %-20s" + "Age: %-10d" + "DOB: %-20s"
                + "Social Security: %-20s" + "Routing Number: %-20d" + "Account Number: %-20d")
                .formatted(name,age,DOB,socialSec,routingNumber,accountNumber);
    }


}
