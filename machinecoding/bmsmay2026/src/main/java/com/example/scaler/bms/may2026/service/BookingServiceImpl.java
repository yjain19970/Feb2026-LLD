package com.example.scaler.bms.may2026.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.scaler.bms.may2026.exception.InvalidRequestException;
import com.example.scaler.bms.may2026.model.Booking;
import com.example.scaler.bms.may2026.model.Show;
import com.example.scaler.bms.may2026.repository.BookingRepository;
import com.example.scaler.bms.may2026.repository.SeatTypeShowRepository;
import com.example.scaler.bms.may2026.repository.ShowRepository;
import com.example.scaler.bms.may2026.repository.ShowSeatRepository;
import com.example.scaler.bms.may2026.repository.UserRepository;

@Service
public class BookingServiceImpl {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SeatTypeShowRepository seatTypeShowRepository;
    
    
    
    
    /**
     * 
     * 1. Should Create the booking and save it to table.
     * 2. Implementation level detail of this function:
     *      a. Validate the input from you database.
     *      b. Repository: get the details of a user using userId
     *      c. get the details of show using showId
     *      d. check whether the input seats are actually avaialble or not
     *      e. if they are available, mark them as blocked ---> TAKE A LOCK
     *      f. create a ticket object
     *      g. save that ticket object in the database. ---> RELEASE THE LOCK
     * 3. Return the booking object if created successfully.
     * 
     * 
     * @param seatNumbers
     * @param showId
     * @param userId
     * @return
     * @throws InvalidRequestException 
     */

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(List<String> seatNumbers, Long showId, Long userId) throws InvalidRequestException {
        Optional<Show> showOptional =  showRepository.findById(showId);
        if(!showOptional.isPresent()){
            throw new InvalidRequestException("ShowId is not correct! ");
        }
        Show show = showOptional.get();

        

        
        return null;
    }
    
}
