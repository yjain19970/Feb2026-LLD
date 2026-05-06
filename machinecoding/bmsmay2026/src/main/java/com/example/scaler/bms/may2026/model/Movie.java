package com.example.scaler.bms.may2026.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "movies")
public class Movie extends BaseModel {
    private String name;
    private String rating;
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
    @ManyToMany
    private List<Actor> actors;
    
    @ElementCollection
    private List<String> languages;

    private Long duration;
}
