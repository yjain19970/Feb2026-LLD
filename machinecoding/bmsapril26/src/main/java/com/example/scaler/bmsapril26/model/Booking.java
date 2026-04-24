package com.example.scaler.bmsapril26.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "bookings")
public class Booking extends BaseModel {
    private Date bookingCreatedAt; // P
    private int amount; // P
    
    
    @OneToMany
    private List<Payment> payments; // NP
    @ManyToOne
    private Show show; // NP
    @ManyToOne
    private User user; // NP
    @ManyToMany
    private List<ShowSeat> showSeats; // NP
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus; // ENUM
}

