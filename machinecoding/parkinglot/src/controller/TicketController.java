package controller;

import dto.GenerateTicketDTO;
import dto.TicketResponseDTO;
import exception.InvalidParamException;
import service.TicketService;

/**
 * support creating of a ticket -- and this should be done at EntryGate. 
 * 
 * 
 */
public class TicketController {
    private TicketService ticketService;
    
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public TicketResponseDTO generateTicket(GenerateTicketDTO reqestDTO) throws InvalidParamException{
        if(isInvalidRequest(reqestDTO)){
            throw new InvalidParamException("Invalid Request DTO!");
        }

        String ticketNumber = null;
        try{
        ticketNumber =  ticketService.generateTicket(reqestDTO.getGateId(), 
            reqestDTO.getParkingLotId(), reqestDTO.getVehicle());
        }catch(Exception e){
            System.out.println("Exception happened: " + e.getMessage());
            throw new InternalError();
        }
        return new TicketResponseDTO(ticketNumber);
    }


    /**
     * HW: complete this up later.
     * @param reqestDTO
     * @return
     */
    private boolean isInvalidRequest(GenerateTicketDTO reqestDTO) {
        return false;
    }
}
