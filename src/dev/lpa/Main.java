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
        Account account = new Account("Robert Melena", 25, "01/06/2000","423-32-4232",335);
        Account account2 = new Account("Esme Valencia", 25, "06/09/2000","331-33-3431",370);
        Account account3 = new Account("Joseph Melena", 22, "04/02/2002","903-57-1193",450);
        Account account4 = new Account("Isaac Melena", 17, "09/18/2007","343-77-9001",500);
        Account account5 = new Account("Serina Melena", 28, "06/13/1997","334-98-1001",600);
        UI ui = new UI();
        ui.begin();
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