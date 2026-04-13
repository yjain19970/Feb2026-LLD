package com.example.feb2026.designpatterns.observerdp;

import java.util.ArrayList;
import java.util.List;

// My Publisher class.
public class Amazon {
    List<OrderPlacedSubscriber> subscribers; 

    public Amazon(){
        subscribers = new ArrayList<>();
    }

    public void registerOrderPlacedSubscriber(OrderPlacedSubscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void deRegisterOrderPlacedSubscriber(OrderPlacedSubscriber subscriber){
        this.subscribers.remove(subscriber);
    }    

    /**
     * Notifying all the subscribers from here.
     * @param input
     */
    public void orderPlaced(OrderPlacedInput input){
        for(OrderPlacedSubscriber subscriber : subscribers){
            subscriber.onOrderPlaced(input);
        }
    }
}
