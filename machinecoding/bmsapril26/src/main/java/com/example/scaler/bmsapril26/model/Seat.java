package com.example.scaler.bmsapril26.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "seats")
public class Seat extends BaseModel {
    private String seatNumber;
    private int colNo;
    private int rowNo;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
