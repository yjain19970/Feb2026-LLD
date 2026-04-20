package transformer;

import dto.CreateTicketDTO;
import model.Ticket;

public class TicketTransformer {
    
    public static CreateTicketDTO convertTicketToTicketDTO(Ticket ticket, long parkingLotId) {
        CreateTicketDTO dto = new CreateTicketDTO();
        dto.setGateId(ticket.getGeneratedAt().getId());
        dto.setId(ticket.getId());
        dto.setVehicle(ticket.getVehicle());
        dto.setParkingLotId(parkingLotId);
        dto.setAssignedSpotId(ticket.getAssignedSpot().getId());
        return dto;
    }
}
