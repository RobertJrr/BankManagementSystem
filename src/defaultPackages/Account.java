package defaultPackages;


//Account class
/*Consists of attributes such as:
    name,
    accountNumber,
    balance

 Will contain setter and getter methods and other helpful methods
*/

public class Account {

    private String name;
    private String accountNumber;
    private double balance;

    public Account(String name, String accountNumber,double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void 
}
