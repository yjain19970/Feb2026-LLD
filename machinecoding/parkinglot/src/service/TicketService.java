package service;

import exception.InvalidParamException;
import exception.SpotNotFoundException;
import model.Ticket;
import model.Vehicle;

public interface TicketService {
    
    public Ticket createTicket(long gateId, long parkingLotId, Vehicle vehicle) throws InvalidParamException, SpotNotFoundException;
}
