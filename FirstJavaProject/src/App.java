import demoAccessmodifiers.BankAccount;

public class App {
    public static void main(String[] args) throws Exception {
        BankAccount bankAccount = new BankAccount();
        //bankAccount.balance = 1000;
        bankAccount.bankAccountNumber = "89293829382";
        //bankAccount.ifscNo = "9we3292";

        bankAccount.deposit(1000);


        bankAccount.getBalance();
        bankAccount.setBalance(133.9283);


        System.out.println("Hello, World!");
    }
}
