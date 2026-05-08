package com.example.scaler.bms.may2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scaler.bms.may2026.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
