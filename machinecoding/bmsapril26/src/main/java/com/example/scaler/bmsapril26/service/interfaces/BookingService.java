package com.example.scaler.bmsapril26.service.interfaces;

import java.util.List;

import com.example.scaler.bmsapril26.model.Booking;

public interface BookingService {
    public Booking createBooking(Long userId, Long showId, List<String> seatNumbers);
}
