package parkinglot.src.service;

import parkinglot.src.exception.InvalidParamException;
import parkinglot.src.exception.SpotNotFoundException;
import parkinglot.src.model.Ticket;
import parkinglot.src.model.Vehicle;

public interface TicketService {
    
    public Ticket createTicket(long gateId, long parkingLotId, Vehicle vehicle) throws InvalidParamException, SpotNotFoundException;
}
