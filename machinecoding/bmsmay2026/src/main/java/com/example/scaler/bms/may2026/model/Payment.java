package com.example.scaler.bms.may2026.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "payments")
public class Payment extends BaseModel {
    private String externalIdentifier;
    private Double totalAmount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMethodType paymentMethodType;
}
