package com.example.feb2026.designpatterns.observerdp.subscribers;

import com.example.feb2026.designpatterns.observerdp.OrderPlacedInput;
import com.example.feb2026.designpatterns.observerdp.OrderPlacedSubscriber;

public class PaymentSubscriber implements OrderPlacedSubscriber {

    @Override
    public void onOrderPlaced(OrderPlacedInput input) {
         System.out.println("PaymentSubscriber...");
    }
    
}
