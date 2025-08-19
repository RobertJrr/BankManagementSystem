package dev.lpa;


//Bank Management Application
//Purpose of this simple Banking program is to replicate the features of an actual banking system
//The Bank will store user accounts and allow users access accounts
//Once account is accessed via proper identification, user will be able to deposit, withdraw or close account
//user information will be stored to a .txt file and removed as needed


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        UI ui = new UI();
//        ui.begin();

        Bank bank = new Bank();
        bank.addNewAccount(new Account("Robert",25,"01/06/2000","123-45-6789",1000));
        bank.addNewAccount(new Account("Esme",25,"01/06/2000","123-45-6719",1000));
        bank.addNewAccount(new Account("Jojo",25,"01/06/2000","123-45-6129",1000));
        bank.addNewAccount(new Account("Isaac",25,"01/06/2000","123-45-6189",1000));
        bank.printAllAccounts();
        bank.deleteAccount();
        bank.printAllAccounts();
    }
}



//try{
//            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            int i = 1;
//            while(i <= 10){
//                bw.write(i * 10 + "\n");
//                i++;
//            }
//            bw.flush();
//
//            String line; //bc everytime we call readLine it skips over if i do System.out.println(br.readLine())
//            while((line = br.readLine()) !=  null){
//                System.out.println(line);
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }