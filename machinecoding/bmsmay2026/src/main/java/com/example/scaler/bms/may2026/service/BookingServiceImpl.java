package com.example.scaler.bms.may2026.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.scaler.bms.may2026.exception.InvalidRequestException;
import com.example.scaler.bms.may2026.exception.SeatNotAvailableException;
import com.example.scaler.bms.may2026.model.Booking;
import com.example.scaler.bms.may2026.model.BookingStatus;
import com.example.scaler.bms.may2026.model.Show;
import com.example.scaler.bms.may2026.model.ShowSeat;
import com.example.scaler.bms.may2026.model.ShowSeatStatus;
import com.example.scaler.bms.may2026.model.User;
import com.example.scaler.bms.may2026.repository.BookingRepository;
import com.example.scaler.bms.may2026.repository.SeatTypeShowRepository;
import com.example.scaler.bms.may2026.repository.ShowRepository;
import com.example.scaler.bms.may2026.repository.ShowSeatRepository;
import com.example.scaler.bms.may2026.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
    @Autowired
    private ReentrantLock lock;
    
    
    
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
     * @throws SeatNotAvailableException 
     */

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(List<String> seatNumbers, Long showId, Long userId) throws InvalidRequestException, SeatNotAvailableException {
        Optional<Show> showOptional =  showRepository.findById(showId);
        if(!showOptional.isPresent()){
            throw new InvalidRequestException("ShowId is not correct! ");
        }

        Optional<User> userOptional =  userRepository.findById(showId);
        if(!userOptional.isPresent()){
            throw new InvalidRequestException("UserId is not correct! ");
        }

        Show show = showOptional.get();
        User user = userOptional.get();
         

        lock.lock();

        List<ShowSeat> allShowSeats = showSeatRepository.findAllByShow(show);
        // [1,2,3,4,5,6,7,8,9,10]

        for(ShowSeat showSeat : allShowSeats){
            // [2,3,4]
            if(seatNumbers.contains(showSeat.getSeat().getSeatNumber()) && 
                !showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                    /**
                     * if 2: AVAILABLE, 3: AVAILABLE, 4: BOOKED
                     */
                throw new SeatNotAvailableException("Seat is not availalble " + showSeat.getSeat().getSeatNumber());
            }
        }

        log.info("fetched all showSeats: " + allShowSeats.size());

        List<ShowSeat> lockedSeats = new ArrayList<>();
        for(ShowSeat showSeat : allShowSeats){
            // [2,3,4]
            if(seatNumbers.contains(showSeat.getSeat().getSeatNumber()) && 
                showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
                lockedSeats.add(showSeat);
                log.info("locked the seat " + showSeat.getSeat().getSeatNumber());
            }
        }

        lock.unlock();

        Booking bookingToBeCreated = new Booking();
        bookingToBeCreated.setBookingCreatedAt(new Date());
        bookingToBeCreated.setBookingStatus(BookingStatus.IN_PROGRESS);
        bookingToBeCreated.setCreatedAt(new Date());
        bookingToBeCreated.setCreatedBy(user);
        bookingToBeCreated.setDeleted(false);
        bookingToBeCreated.setPayment(null); // create a payment object and add it here. This is a Todo. 
        bookingToBeCreated.setShow(show);
        bookingToBeCreated.setShowSeats(allShowSeats);
        bookingToBeCreated.setTotalAmount(calculateTotalAmount(lockedSeats));
        bookingToBeCreated.setUpdatedAt(new Date());

        // Finally save this booking.
        Booking bookingCreated =  bookingRepository.save(bookingToBeCreated);
        return bookingCreated;
    }



    private Double calculateTotalAmount(List<ShowSeat> lockedSeats) {
        /**
         * ToDo: 
         * 1. Get the show and get the seatType
         * 2. Define a new method in your repository to get all the seatType prices
         * 3. Once you have all the prices for all seatTypes, just Multiply to get
         *    the total amount.
         */
        return 10.0;
    }
    
}
