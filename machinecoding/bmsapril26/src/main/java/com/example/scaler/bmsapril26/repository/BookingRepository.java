package com.example.scaler.bmsapril26.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scaler.bmsapril26.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    /**
     * 
     * save(Booking b);
     * getAllBookings();
     * getBookingById(id);
     * deleteBookingById(id);
     * 
     */
}
