package com.example.scaler.bms.may2026.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.scaler.bms.may2026.dto.CreateBookingRequestDTO;
import com.example.scaler.bms.may2026.dto.CreateBookingResponseDTO;
import com.example.scaler.bms.may2026.dto.TicketDTO;
import com.example.scaler.bms.may2026.exception.InvalidRequestException;
import com.example.scaler.bms.may2026.model.Booking;
import com.example.scaler.bms.may2026.service.BookingServiceImpl;
import com.example.scaler.bms.may2026.translator.BookingTranslator;

import jakarta.websocket.server.PathParam;
import lombok.extern.log4j.Log4j2;

/**
 * REST has concept of HTTP methods.
 * 
 * GET -- get any data from the server
 * POST -- create any data on the server
 * PUT -- update any data on the server
 * DELETE -- delete anything from the server 
 * 
 * 
 * 
 * 
 * 
 */
@RestController
@Log4j2
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingServiceImpl;

    
    @PostMapping("/ticket")
    public CreateBookingResponseDTO bookTicket(@RequestBody CreateBookingRequestDTO requestDTO) throws InvalidRequestException{
        if(isInvalidRequest(requestDTO)){
            throw new InvalidRequestException("Invalid Request.");
        }

        Booking booking =  bookingServiceImpl.createBooking(requestDTO.getSeatNumbers(), 
                        requestDTO.getShowId(), requestDTO.getUserId());
        
        log.info("created booking successfully with id: " + booking.getId());
        return BookingTranslator.transform(booking, requestDTO);
    }

    private boolean isInvalidRequest(CreateBookingRequestDTO requestDTO) {
        // ToDo: complete it.
        return false;
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<TicketDTO> getTicket(@PathParam("id") Long ticketId){
        // localhost:8083/ticket/1
        TicketDTO ticket = new TicketDTO();
        ticket.setCreatedBy(null);
        ticket.setTicketId(1234L);
        ticket.setTotalAmount(1000.0);
        
        return ResponseEntity.ok(ticket);
    }


    
    
}
