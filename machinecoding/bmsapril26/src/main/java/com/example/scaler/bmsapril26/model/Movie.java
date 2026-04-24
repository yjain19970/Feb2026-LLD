package com.example.scaler.bmsapril26.model;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "movies")
public class Movie extends BaseModel {
    private String name;
    private String rating;
    private List<Actor> actors;
    // private List<Language> languages;
}
