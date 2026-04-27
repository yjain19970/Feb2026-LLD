package com.example.scaler.bmsapril26.translator;

import java.util.ArrayList;
import java.util.List;

import com.example.scaler.bmsapril26.dto.BookingRequestDTO;
import com.example.scaler.bmsapril26.dto.BookingResponseDTO;
import com.example.scaler.bmsapril26.dto.ErrorDTO;
import com.example.scaler.bmsapril26.dto.SeatDTO;
import com.example.scaler.bmsapril26.model.Booking;
import com.example.scaler.bmsapril26.model.BookingStatus;
import com.example.scaler.bmsapril26.model.ShowSeat;

public class BookingTranslator {
    
    public static BookingResponseDTO translate(Booking booking){
        BookingResponseDTO responseDTO = new BookingResponseDTO();
        if(booking==null || booking.getBookingStatus().equals(BookingStatus.FAILED)){
            responseDTO.setErrorDTO(new ErrorDTO());
        }else{
            responseDTO.setBookedSeats(toBookedSeats(booking.getShowSeats()));
            responseDTO.setBookingId(booking.getId());
            responseDTO.setBookingStatus(booking.getBookingStatus());
        }
        return responseDTO;
    }

    private static List<SeatDTO> toBookedSeats(List<ShowSeat> showSeats) {
        List<SeatDTO> response = new ArrayList<>();
        for(ShowSeat showSeat : showSeats){
            SeatDTO seatDTO = new SeatDTO();
            seatDTO.setSeatId(showSeat.getSeat().getId());
            seatDTO.setSeatNumber(showSeat.getSeat().getSeatNumber());

            response.add(seatDTO);
        }
        return response;
    }
}
