package com.example.scaler.bmsapril26.service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scaler.bmsapril26.model.Booking;
import com.example.scaler.bmsapril26.repository.BookingRepository;
import com.example.scaler.bmsapril26.repository.ShowRepository;
import com.example.scaler.bmsapril26.repository.ShowSeatRepository;
import com.example.scaler.bmsapril26.repository.UserRepository;
import com.example.scaler.bmsapril26.service.interfaces.BookingService;

/**
 * All the bean classes in spring are SINGLETON.
 */



@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepo;
    @Autowired
    private ReentrantLock lock;

    @Override
    public Booking createBooking(Long userId, Long showId, List<String> seatNumbers) {
        /**
         * Steps:
         * 
         * One seat for a show: should ONLY be booked once. 
         * 
         * 1. get the userDetails given userId.
         * 2. get the showDetails using showId.
         * 
         * 
         * 3. Get the showSeats which user requested.
         * 4. Check if all the seats are available
         * 5. If all the seats are available, then mark them as LOCKED
         * 6. Save and update the DB
         * 
         * 
         * 7. Create the booking object
         * 8. Return the response
         * 
         * 
         */
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }
    
}
