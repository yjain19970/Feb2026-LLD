package com.example.scaler.bmsapril26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.scaler.bmsapril26.dto.BookingRequestDTO;
import com.example.scaler.bmsapril26.dto.BookingResponseDTO;
import com.example.scaler.bmsapril26.exception.BadRequestException;
import com.example.scaler.bmsapril26.exception.InternalErrorException;
import com.example.scaler.bmsapril26.model.Booking;
import com.example.scaler.bmsapril26.service.interfaces.BookingService;
import com.example.scaler.bmsapril26.translator.BookingTranslator;


@Controller // Beans in SpringBoot. 
//@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    

    public BookingResponseDTO createBooking(BookingRequestDTO requestDTO) throws BadRequestException, InternalErrorException{
        /**
         * Steps:
         * 1. Valdiate the Input
         * 2. Make service call and capture the response
         * 3. Translate the response to DTO
         * 4. Return
         */
        if(invalidRequestDTO(requestDTO)){
            // Request was Invalid. 
            throw new BadRequestException("InvalidRequest. Please pass necessary params.");
        }

        BookingResponseDTO responseDTO = null;
        try{
            Booking createdBooking =  bookingService.createBooking(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getSeatNumber());
            responseDTO =  BookingTranslator.translate(createdBooking);
        }catch(Exception e){
            System.out.println("Exception happened: " + e.getStackTrace());
            throw new InternalErrorException();
        }
        return responseDTO;
    }

    private boolean invalidRequestDTO(BookingRequestDTO requestDTO){
        if(requestDTO ==null){
            return true;
        }
        if(requestDTO.getSeatNumber()==null || 
           requestDTO.getShowId() ==null || requestDTO.getUserId()==null){
            return true;
        }
        return false;
    }


    
}

/**
 * Two type of Dependency Injection mechanisms:
 * 1. @Autowired -- This is simpler.
 * 2. Constructor based. --- this is better way to Inject a class.
 */



/**
 * HW:
 * 
 * Currently this is a JAR application
 * Convert this to WAR application (a REST application)
 *  - Inject the WAR module
 *  - Inject the SpringWEb library for SpringBoot
 */