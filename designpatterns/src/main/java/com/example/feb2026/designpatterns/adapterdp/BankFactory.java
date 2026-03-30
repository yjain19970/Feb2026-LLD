package com.example.feb2026.designpatterns.adapterdp;

import com.example.feb2026.designpatterns.adapterdp.adapter.HDFCBankAPIAdapter;
import com.example.feb2026.designpatterns.adapterdp.adapter.ICICIBankAPIAdapter;

public class BankFactory {
    
    public static BankAPI getBankAPIImpl(String type){
        if(type=="HDFC"){
            return new HDFCBankAPIAdapter();
        }
        return new ICICIBankAPIAdapter();
    }
}
