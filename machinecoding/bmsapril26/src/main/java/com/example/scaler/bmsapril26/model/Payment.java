package com.example.scaler.bmsapril26.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "payments")
public class Payment extends BaseModel {
    
    private String externalRefNumber;
    private double amount;
    private PaymentStatus paymentStatus;
    private PayMethod paymentMethodType;
}
