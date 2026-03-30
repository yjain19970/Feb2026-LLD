package com.example.feb2026.designpatterns.adapterdp;

public class PhonePe {
    // This bankAPI : this is an Interface.
    private BankAPI bankAPI;
    

    public PhonePe(BankAPI bankAPI) {
        this.bankAPI = bankAPI;
    }


    public void payToSomeone(String upiID, float amount){
        bankAPI.sendMoney(upiID, amount);
    }


    public float getBalance(String accountNo){
        return bankAPI.fetchBalance(accountNo);
    }
}
