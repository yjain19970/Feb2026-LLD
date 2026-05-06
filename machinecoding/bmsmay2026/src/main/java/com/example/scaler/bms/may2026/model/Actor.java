package com.example.scaler.bms.may2026.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "actors")
public class Actor extends BaseModel {
    private String name;
}
