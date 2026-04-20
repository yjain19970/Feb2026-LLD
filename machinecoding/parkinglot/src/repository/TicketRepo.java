package parkinglot.src.repository;

import java.util.Map;
import java.util.Optional;

import parkinglot.src.model.Ticket;



public class TicketRepo {
    /**
     * A class which would abstract out queries before making call to SQL.
     */
    Map<Long,Ticket> ticketRepoMap; // this id should be increamental.
    private long lastSavedId;


    public TicketRepo(Map<Long, Ticket> ticketRepoMap) {
        this.ticketRepoMap = ticketRepoMap;
        this.lastSavedId = 0L;
    }

    public Optional<Ticket> getById(Long id){
        if(!ticketRepoMap.containsKey(id)){
            return Optional.empty();
        }

        return Optional.of(ticketRepoMap.get(id));
    }

    public Optional<Ticket> createTicket(Ticket parkingLot){
        lastSavedId++;
        
        parkingLot.setId(lastSavedId);
        System.out.println("LastSavedId: " + lastSavedId);
        ticketRepoMap.put(lastSavedId, parkingLot);
        System.out.println("ticketRepoMap: " + ticketRepoMap);

        return Optional.of(ticketRepoMap.get(lastSavedId));
    }   
}
