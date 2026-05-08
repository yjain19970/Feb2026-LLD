package com.example.scaler.bms.may2026.dto;

import java.util.List;

import lombok.Data;

@Data // @getter, @setter, @AllArgConstructor
public class CreateBookingRequestDTO {
    private Long showId;
    private List<String> seatNumbers;
    private Long userId;
}
