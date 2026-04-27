package com.example.scaler.bmsapril26.dto;

import java.util.List;

import com.example.scaler.bmsapril26.model.BookingStatus;

import lombok.Data;

@Data
public class BookingResponseDTO {
    private BookingStatus bookingStatus;
    private Long bookingId;
    private List<SeatDTO> bookedSeats;

    // Standard way to return errors from your backend service.
    private ErrorDTO errorDTO;
}
