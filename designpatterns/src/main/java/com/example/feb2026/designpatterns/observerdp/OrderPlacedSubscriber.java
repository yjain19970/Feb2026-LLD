package com.example.feb2026.designpatterns.observerdp;

/**
 * Should be Implemented by all the
 * classes who wants to subscribe to
 * order place event.
 */
public interface OrderPlacedSubscriber {
    
    void onOrderPlaced(OrderPlacedInput input);
}
