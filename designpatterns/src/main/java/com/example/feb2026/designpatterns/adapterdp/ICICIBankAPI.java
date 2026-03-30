package com.example.feb2026.designpatterns.adapterdp;

// Belongs to ICICI Bank.
public class ICICIBankAPI {
    public boolean payMoney(float amount, String upiId){
        return true;
    }

    public float fetchMoney(String accountNumber, IciciFetchBalanceRequestType fetchBalanceRequestType){
        return 0.0f;
    }

    public float getLatestBalance(String accountNo){
        return 0.0f;
    }
}
