package com.example.scaler.bms.may2026.dto;

import com.example.scaler.bms.may2026.model.User;

import lombok.Data;

@Data
public class TicketDTO {
    private Long ticketId;
    private User createdBy;
    private Double totalAmount;
    
}
