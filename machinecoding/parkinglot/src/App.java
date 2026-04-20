import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.TicketController;
import dto.CreateTicketDTO;
import model.Operator;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingLotGate;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;
import model.enums.FeesCalculatorStrategyType;
import model.enums.GateStatus;
import model.enums.GateType;
import model.enums.ParkingLotStatus;
import model.enums.SpotAssignmentStrategyType;
import model.enums.VehicleType;
import repository.GateRepo;
import repository.ParkingLotRepo;
import repository.TicketRepo;
import service.TicketServiceImpl;

public class App {
    public static void main(String[] args) throws Exception {
        Map<Long, ParkingLot> parkingLotMap = new HashMap<>();
        parkingLotMap.put(1L, createNewParkingLot());

        Map<Long, ParkingLotGate> gateRepoMap = new HashMap();
        gateRepoMap.put(1L, createNewGate());

        // ALL REPOs
        TicketRepo ticketRepo = new TicketRepo(new HashMap<>());
        ParkingLotRepo parkingLotRepo = new ParkingLotRepo(parkingLotMap);
        GateRepo gateRepo = new GateRepo(gateRepoMap);

        //SpotAssignmentStrategy strategy = new RandomSpotAssignmentStrategyImpl();


        TicketServiceImpl ticketService = new TicketServiceImpl(ticketRepo,
         gateRepo, parkingLotRepo);

        TicketController ticketController = new TicketController(ticketService);

        CreateTicketDTO ticketRequestDTO = generateTicket();
        CreateTicketDTO response = ticketController.createTicket(ticketRequestDTO);

        System.out.println("Ticket Response: " + response.getId() + " spot: "+ response.getAssignedSpotId());

    }
    private static ParkingLot createNewParkingLot() {
        List<ParkingSpot> spots = Arrays.asList(new ParkingSpot(1));
        List<ParkingFloor> parkingFloors = Arrays.asList(new ParkingFloor(spots,"1" ));
        List<ParkingLotGate> gates = Arrays.asList(createNewGate());

        return new ParkingLot(parkingFloors, gates, 
        Arrays.asList(VehicleType.FOUR_WHEELER), ParkingLotStatus.OPEN, SpotAssignmentStrategyType.RANDOM, FeesCalculatorStrategyType.DYNAMIC);
    }

    private static ParkingLotGate createNewGate() {
        return new ParkingLotGate(GateType.ENTRY, new Operator(100, " Yash"), GateStatus.OPEN);
    }

    private static CreateTicketDTO generateTicket() {
        Vehicle vehicle  = new Vehicle("KA511234", VehicleType.FOUR_WHEELER);
        return new CreateTicketDTO(vehicle, 1L,1L);
    }


}
