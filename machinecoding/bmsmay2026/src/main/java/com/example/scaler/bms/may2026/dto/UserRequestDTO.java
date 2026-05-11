package com.example.scaler.bms.may2026.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserRequestDTO {
    @Setter
    private String userEmail;
    @Setter
    private String password;
    @Setter
    private Long userId;

    // either ErrorDTO should be present OR the above should be present.
    @Setter
    private ErrorDTO errorDTO;
}
