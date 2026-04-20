package parkinglot.src.service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import parkinglot.src.factory.ParkingSpotAssignmentFactory;
import parkinglot.src.model.ParkingSpot;
import parkinglot.src.model.Ticket;
import parkinglot.src.model.enums.SpotAssignmentStrategyType;
import parkinglot.src.repository.GateRepo;
import parkinglot.src.repository.ParkingLotRepo;
import parkinglot.src.repository.TicketRepo;



public class TicketServiceImpl implements TicketService {



    @Override
    public Ticket createTicket(long gateId, long parkingLotId, Vehicle vehicle) throws InvalidParamException, SpotNotFoundException {
        /**
         * S1. perform validatiosn on the input
         *  - check whether parkingLotId is correct or not.
         *  - check whether gateId is associated with the given parkingLotId or not.
         * S2. Fetch the gate using gateId from Repository
         * S3. fetch parkingLOt using parkingLotId from respository & check whether you have a spot available or not.
         * S4. Generate ticket, save it in your ticket repo
         * S5. Return ticket.
         */
        Optional<ParkingLotGate> gateOptional = gateRepo.getById(gateId);
        if(gateOptional.isEmpty()){
            // that means gate does not exist.
            throw new InvalidParamException("Gate id is not correct");
        }
        ParkingLotGate gate = gateOptional.get();
        System.out.println("Fetched parkingLotGate:" + gate.toString());
        

        Optional<ParkingLot> lotOptional = parkingLotRepo.getById(parkingLotId);
        if(lotOptional.isEmpty()){
            throw new InvalidParamException("parking lot id is not correct");
        }
        ParkingLot parkingLot = lotOptional.get();
        System.out.println("Fetched parkingLot:" + parkingLot.toString());

        /**
         * Assign a parkingSpot
         */
        SpotAssignmentStrategyType strategyType =  parkingLot.getSpotAssignmentStrategyType();
        SpotAssignmentStrategy assignmentStrategy =  ParkingSpotAssignmentFactory.getSpotAssignmentStrategy(strategyType);
        
        ParkingSpot parkingSpot = assignmentStrategy.findParkingSpot(vehicle, parkingLot);
        System.out.print("Assigned a parkingSpot...");

        /**
         * Create the ticket now.
         */
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), 
            new Date(), 
            vehicle, 
            parkingSpot, 
            gate, 
            gate.getCurrentOperator());
        Optional<Ticket>  tOptional =  ticketRepo.createTicket(ticket);
        if(tOptional.isEmpty()){
            // Some problem in persisting the ticket.
        }
        Ticket ticketWithId =  tOptional.get();
        
        System.out.println("Ticket generated.... " + ticket.getCreatedAt() + " " + ticket.getGeneratedAt().getId() + " " +ticket.getGeneratedBy());
        return ticketWithId;
    }
    
}
