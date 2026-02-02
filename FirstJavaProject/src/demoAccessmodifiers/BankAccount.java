package demoAccessmodifiers;
public class BankAccount {
    // private
    private double balance;
    private String ownerName;
    // public
    public String bankAccountNumber;
    // default
    String ifscNo;


    // Deposit method
    public void deposit(double amount) {
        if(amount > 0){
          balance += amount;
        }
    }

    // Withdraw method (checks if enough balance)
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Display balance
    public void showBalance() {
        System.out.println(ownerName + "'s Balance: $" + balance);
    }    


    
    // Main method to test
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();
        myAccount.balance = 1000;
        myAccount.ownerName = "Yash";
        myAccount.bankAccountNumber = "18273642222";
        Instructor instructor = new Instructor();
        
    }

    protected double getBalance() {
        return balance + 10.0;
    }
    public void setBalance(double balance) {
        if(balance !=0){
            this.balance = balance;
        }
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
    public String getIfscNo() {
        return ifscNo;
    }
    public void setIfscNo(String ifscNo) {
        this.ifscNo = ifscNo;
    }
}
