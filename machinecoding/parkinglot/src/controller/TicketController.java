package parkinglot.src.controller;



public class TicketController {
    private TicketService ticketService;
    
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public CreateTicketDTO createTicket(CreateTicketDTO reqDto) throws InvalidParamException, SpotNotFoundException{
        System.out.println("Received Request for create ticket....");
        Ticket ticket = ticketService.createTicket(reqDto.getGateId(), reqDto.getParkingLotId(), reqDto.getVehicle());
        System.out.println("Received response from ticket service..." + ticket.toString());
        return TicketTransformer.convertTicketToTicketDTO(ticket, reqDto.getParkingLotId());
    }
}
