package com.example.feb2026.designpatterns.adapterdp.adapter;

import com.example.feb2026.designpatterns.adapterdp.BankAPI;
import com.example.feb2026.designpatterns.adapterdp.HdfcBankAPI;

// This adapter has only one thing to do: Deal with HDFC bank API,.
public class HDFCBankAPIAdapter implements BankAPI {
    private HdfcBankAPI hdfcBankAPI;

    @Override
    public void sendMoney(String upiID, float amount) {
        hdfcBankAPI.transferMoney(amount, upiID);
    }

    @Override
    public float fetchBalance(String accountNo) {
        return hdfcBankAPI.getBalance(accountNo);
    }
}
