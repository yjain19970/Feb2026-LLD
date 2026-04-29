package repository;

import java.util.HashMap;
import java.util.Map;

import model.Ticket;

public class TicketRepo {
    private Map<Long, Ticket> ticketRepoMap;
    private long lastSavedId;

    public TicketRepo() {
        this.ticketRepoMap = new HashMap<>();
        this.lastSavedId = 0L;
    }

    public Ticket save(Ticket ticket){
        lastSavedId++;

        ticket.setId(lastSavedId);
        ticketRepoMap.put(lastSavedId, ticket);
         System.out.println("Saved ticket with Id: " + lastSavedId);
        return ticket;
    }

    public Ticket getById(long id) throws Exception{
        if(!ticketRepoMap.containsKey(id)){
            throw new Exception();
        }
        return ticketRepoMap.get(id);
    }    
}
