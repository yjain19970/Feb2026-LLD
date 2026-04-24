package com.example.scaler.bmsapril26.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "seats")
public class Seat extends BaseModel {
    private String seatNumber;
    private int colNo;
    private int rowNo;
    private SeatType seatType;
}
