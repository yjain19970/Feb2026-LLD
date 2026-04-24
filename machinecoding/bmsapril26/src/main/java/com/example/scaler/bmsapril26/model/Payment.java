package com.example.scaler.bmsapril26.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "payments")
public class Payment extends BaseModel {
    private String externalRefNumber;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.ORDINAL)
    private PayMethod paymentMethodType;
}
