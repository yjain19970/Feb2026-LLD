package com.example.scaler.bms.may2026.translator;

import com.example.scaler.bms.may2026.dto.CreateBookingRequestDTO;
import com.example.scaler.bms.may2026.dto.CreateBookingResponseDTO;
import com.example.scaler.bms.may2026.model.Booking;

public class BookingTranslator {

    public static CreateBookingResponseDTO transform(Booking booking, CreateBookingRequestDTO requestDTO) {
        CreateBookingResponseDTO responseDTO = new CreateBookingResponseDTO();
        responseDTO.setBookedSeatNumbers(requestDTO.getSeatNumbers());
        responseDTO.setBookingStatus(booking.getBookingStatus());
        responseDTO.setTicketId(booking.getId());
        
        return responseDTO;
    }
    
}
