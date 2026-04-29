package service;

import model.Vehicle;

public interface TicketService {
    
    public String generateTicket(Long gateId, Long parkingLotId, Vehicle vehicle) throws Exception;
}
