package com.example.scaler.bmsapril26.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "bookings")
public class Booking extends BaseModel {
    private BookingStatus bookingStatus;
    private List<ShowSeat> bookedSeats;
    private User user;
    private Date bookingCreatedAt;
    private Show show;
    private double amount;
    private Payment payment;
}
