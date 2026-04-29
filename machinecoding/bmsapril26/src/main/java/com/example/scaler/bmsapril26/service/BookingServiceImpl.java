package com.example.scaler.bmsapril26.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scaler.bmsapril26.exception.BadRequestException;
import com.example.scaler.bmsapril26.exception.SeatNotAvailableException;
import com.example.scaler.bmsapril26.model.Booking;
import com.example.scaler.bmsapril26.model.BookingStatus;
import com.example.scaler.bmsapril26.model.Show;
import com.example.scaler.bmsapril26.model.ShowSeat;
import com.example.scaler.bmsapril26.model.ShowSeatStatus;
import com.example.scaler.bmsapril26.model.User;
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
    public Booking createBooking(Long userId, Long showId, List<String> seatNumbers) throws BadRequestException, SeatNotAvailableException {
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
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new BadRequestException("UserId is not correct!");
        }
        User userDetail = userOptional.get();

        Optional<Show> showOptional =  showRepository.findById(showId);
        if(!showOptional.isPresent()){
            throw new BadRequestException("ShowId is not correct!");
        }
        Show showDetail = showOptional.get();

        // Take a lock to book the seats.
        lock.lock();

        List<ShowSeat> allShowSeats =  showSeatRepo.findByShow(showDetail);
        // allShowSeats: [1,2,3,4,5,6,7]
        // seatNumbers: [1,2,3]
        for(ShowSeat showSeat : allShowSeats){
            if(seatNumbers.contains(showSeat.getSeat().getSeatNumber()) && 
            !showSeat.getShowSeatStatus().equals(ShowSeatStatus.EMPTY)){
                throw new SeatNotAvailableException("Requested seats are not available!");
            }
        }

        // If all the seats that user has requested are available. 
        // Now I need to update the seatStatus to BOOKED.
        List<ShowSeat> savedSeats = new ArrayList<>();
        for(ShowSeat showSeat: allShowSeats){
            if(seatNumbers.contains(showSeat.getSeat().getSeatNumber())){
                showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
                savedSeats.add(showSeat);
            }
        }
        // Release the lock
        lock.unlock();

        Booking booking = new Booking();
        /**
         * In order to fetch the price: how you would do that?
         * 
         * HW: 
         * 1. CreateRepository for SeatTypeShow
         * 2. Get the prices for the input seatType
         * 3. Calculate the total price by multiplying it. 
         * 4. Update the amount here.
         * 
         * 
         */
        booking.setAmount(100);
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        /**
         * 
         * Either you take payment as part of the Input from the user.
         * OR
         * You trigger another flow which takes care of payement. Once the payment is captured,
         * you update it here.
         */
        booking.setPayments(null);
        booking.setShow(showDetail);
        booking.setShowSeats(allShowSeats);
        booking.setUser(userDetail);
        booking.setBookingCreatedAt(new Date());
        Booking createdBooking =  bookingRepository.save(booking);
        return createdBooking;
    }
    
}


/**
 * 
 * Another way to solve this is using DB level locks
 * 
 * using query: Select for update
 * 
 * 
 */