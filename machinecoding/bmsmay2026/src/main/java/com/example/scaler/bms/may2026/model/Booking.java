package com.example.scaler.bms.may2026.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "bookings")
public class Booking extends BaseModel {

    @Enumerated(EnumType.ORDINAL)    
    private BookingStatus bookingStatus;
    @ManyToOne
    private User createdBy;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Payment payment;
    private Date bookingCreatedAt;
    private Double totalAmount;
}
