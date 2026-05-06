package com.example.scaler.bms.may2026.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel {
    private String email;
    private String password;
    
}
