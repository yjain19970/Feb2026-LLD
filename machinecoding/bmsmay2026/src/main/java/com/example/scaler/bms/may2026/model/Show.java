package com.example.scaler.bms.may2026.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    private Date startTime;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
}
