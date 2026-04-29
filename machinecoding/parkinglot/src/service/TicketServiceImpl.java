package service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import exception.SpotNotFoundException;
import factory.ParkingSpotAssignmentFactory;
import model.ParkingLot;
import model.ParkingLotGate;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;
import model.enums.SpotAssignmentStrategyType;
import repository.ParkingLotGateRepo;
import repository.ParkingLotRepo;
import repository.TicketRepo;
import strategy.SpotAssignmentStrategy;

public class TicketServiceImpl implements TicketService {
    private ParkingLotRepo parkingLotRepo;
    private ParkingLotGateRepo parkingLotGateRepo;
    private TicketRepo ticketRepo;
    

    public TicketServiceImpl(ParkingLotRepo parkingLotRepo, ParkingLotGateRepo parkingLotGateRepo,
            TicketRepo ticketRepo) {
        this.parkingLotRepo = parkingLotRepo;
        this.parkingLotGateRepo = parkingLotGateRepo;
        this.ticketRepo = ticketRepo;
    }


    @Override
    public String generateTicket(Long gateId, Long parkingLotId, Vehicle vehicle) throws Exception {
        /**
         * S1. Get the parkingLot using parkingLotId. 
         * S2. validate the parkingLot.
         * S3. Get the gate using the gateId
         * S4. validate the gate
         * S5. Given the parkingLot, get me the spotAssignmentType
         * S6. Get me the Object of SpotAssignemtnStrategy using the type. ---> FACTORY DP.
         * S7. We will have to assign the Spott
         * S8. Finally create the ticket.
         * 
         * // Todo: Create SpotAssignemnt classes as singleton.
         */
        Optional<ParkingLot> parkingLotOptional =  parkingLotRepo.getById(parkingLotId);
        if(!parkingLotOptional.isPresent()){
             System.out.println("ParkingLot is not valid");
            throw new Exception("ParkingLot Id is not valid");
        }
        ParkingLot parkingLot = parkingLotOptional.get();

        Optional<ParkingLotGate> parkingGateOptional =  parkingLotGateRepo.getById(gateId);
        if(!parkingGateOptional.isPresent()){
             System.out.println("GateId is not valid");
            throw new Exception("GateId is not valid");
        }
        ParkingLotGate parkingLotGate = parkingGateOptional.get();

        System.out.println("ParkingLot: " + parkingLot);
        System.out.println("ParkingFloor: " + parkingLot.getParkingFloors().size());

        SpotAssignmentStrategyType spotAssignmentStrategyType  = parkingLot.getSpotAssignmentStrategyType();

        SpotAssignmentStrategy spotAssignmentStrategy =  ParkingSpotAssignmentFactory
            .getSpotAssignmentByType(spotAssignmentStrategyType);

        System.out.println("Finding the spot now.");
        
        Optional<ParkingSpot> assignedParkignSpotOptional =  spotAssignmentStrategy
            .findParkingSpot(parkingLot, vehicle.getVehicleType());
        
        
        if(!assignedParkignSpotOptional.isPresent()){
            System.out.println("no parking spots available!");
            throw new SpotNotFoundException("no parking spots available!");
        }

        ParkingSpot parkingSpot = assignedParkignSpotOptional.get();

        // finally create the ticket and persist it.
        Ticket newTicket = new Ticket(UUID.randomUUID().toString(),
             new Date(), vehicle, parkingSpot,
                 parkingLotGate, parkingLotGate.getCurrentOperator());
        
        System.out.println("Created the ticket successfully. Now saving it");
        Ticket savedTicket =  ticketRepo.save(newTicket);
        return savedTicket.getNumber();
    }

}