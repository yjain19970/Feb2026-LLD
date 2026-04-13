package com.example.feb2026.designpatterns.observerdp;

import com.example.feb2026.designpatterns.observerdp.subscribers.DeliveryOptionsSubscriber;
import com.example.feb2026.designpatterns.observerdp.subscribers.NotifySellerSubscriber;
import com.example.feb2026.designpatterns.observerdp.subscribers.PaymentSubscriber;

public class Client {
 public static void main(String[] args) {
    
    NotifySellerSubscriber notifySellerSubscriber = new NotifySellerSubscriber();
    DeliveryOptionsSubscriber deliveryOptionsSubscriber = new DeliveryOptionsSubscriber();
    PaymentSubscriber paymentSubscriber = new PaymentSubscriber();

    Amazon amazon = new Amazon();
    amazon.registerOrderPlacedSubscriber(paymentSubscriber);
    amazon.registerOrderPlacedSubscriber(notifySellerSubscriber);
    amazon.registerOrderPlacedSubscriber(deliveryOptionsSubscriber);


    // finally
    amazon.orderPlaced(new OrderPlacedInput());

    System.out.println("After DeRegistering.....");
    amazon.deRegisterOrderPlacedSubscriber(paymentSubscriber);
    amazon.orderPlaced(new OrderPlacedInput());

 }   
}
