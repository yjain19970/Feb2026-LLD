package com.example.scaler.bms.may2026.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel {

    private String seatNumber;
    private int rowNo;
    private int colNo;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

}
