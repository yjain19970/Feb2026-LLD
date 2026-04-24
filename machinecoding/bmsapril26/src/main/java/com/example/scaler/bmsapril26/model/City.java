package com.example.scaler.bmsapril26.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "cities")
public class City extends BaseModel {
  private String name;   
}
