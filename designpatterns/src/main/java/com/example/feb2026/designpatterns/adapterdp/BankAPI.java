package com.example.feb2026.designpatterns.adapterdp;

// Your interface
public interface BankAPI {
    void sendMoney(String upiID, float amount);

    float fetchBalance(String accountNo);
}
