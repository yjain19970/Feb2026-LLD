package com.example.feb2026.designpatterns.adapterdp.adapter;

import com.example.feb2026.designpatterns.adapterdp.BankAPI;
import com.example.feb2026.designpatterns.adapterdp.ICICIBankAPI;
import com.example.feb2026.designpatterns.adapterdp.IciciFetchBalanceRequestType;

public class ICICIBankAPIAdapter implements BankAPI {
    private ICICIBankAPI iciciBankAPI;

    @Override
    public void sendMoney(String upiID, float amount) {
        iciciBankAPI.payMoney(amount, upiID);
    }

    @Override
    public float fetchBalance(String accountNo) {
        // fetchMoney is deprecated. 
        return iciciBankAPI.getLatestBalance(accountNo);
    }
    
}
