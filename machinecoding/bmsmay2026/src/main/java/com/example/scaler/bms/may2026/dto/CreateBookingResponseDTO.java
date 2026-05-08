package com.example.scaler.bms.may2026.dto;

import java.util.List;

import com.example.scaler.bms.may2026.model.BookingStatus;

import lombok.Data;

@Data
public class CreateBookingResponseDTO {
    private Long ticketId;
    private List<String> bookedSeatNumbers;
    private BookingStatus bookingStatus;
}
