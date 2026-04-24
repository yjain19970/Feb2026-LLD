package com.example.scaler.bmsapril26.model;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "screens")
public class Screen extends BaseModel {
    private String name;
    private List<Seat> seats;
    private List<Feature> features;
}
