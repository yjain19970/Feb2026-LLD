package com.example.feb2026.designpatterns.observerdp.subscribers;

import com.example.feb2026.designpatterns.observerdp.OrderPlacedInput;
import com.example.feb2026.designpatterns.observerdp.OrderPlacedSubscriber;

public class DeliveryOptionsSubscriber implements OrderPlacedSubscriber {

    @Override
    public void onOrderPlaced(OrderPlacedInput input) {
        System.out.println("DeliveryOptionsSubscriber...");
    }
    
}
