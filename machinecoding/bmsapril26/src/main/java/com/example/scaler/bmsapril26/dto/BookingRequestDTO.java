package com.example.scaler.bmsapril26.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookingRequestDTO {
    private List<String> seatNumber;
    private Long showId;
    private Long userId;
}
