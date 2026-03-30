package com.example.feb2026.designpatterns.adapterdp;


public class Client {
    public static void main(String[] args) {
        // S1: Create object using Factory
        BankAPI bankAPI = BankFactory.getBankAPIImpl("HDFC");
        

        // S2: Call Phonpe.
        PhonePe phonePe = new PhonePe(bankAPI);


        // making calls to phonePe.
        phonePe.getBalance("12345");
        phonePe.payToSomeone("yash@sbi", 10);
    }
}
