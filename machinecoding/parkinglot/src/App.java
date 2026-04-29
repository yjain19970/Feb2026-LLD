

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.ParkingLotController;
import controller.TicketController;
import dto.CreateParkingLotRequestDTO;
import dto.GenerateTicketDTO;
import dto.ParkingFloorDTO;
import dto.ParkingLotGateDTO;
import dto.TicketResponseDTO;
import model.Operator;
import model.ParkingLotGate;
import model.ParkingSpot;
import model.Vehicle;
import model.enums.FeesCalculatorStrategyType;
import model.enums.GateStatus;
import model.enums.GateType;
import model.enums.ParkingLotStatus;
import model.enums.SpotAssignmentStrategyType;
import model.enums.VehicleType;
import repository.ParkingFloorRepo;
import repository.ParkingLotGateRepo;
import repository.ParkingLotRepo;
import repository.ParkingSpotRepo;
import repository.TicketRepo;
import service.ParkingLotService;
import service.ParkingLotServiceImpl;
import service.TicketService;
import service.TicketServiceImpl;





public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //Created Repository
        ParkingFloorRepo parkingFloorRepo = new ParkingFloorRepo();
        ParkingLotRepo parkingLotRepo = new ParkingLotRepo();
        ParkingLotGateRepo parkingLotGateRepo = new ParkingLotGateRepo();
        TicketRepo ticketRepo = new TicketRepo();
        ParkingSpotRepo parkingSpotRepo = new ParkingSpotRepo();

        //Created Service
        ParkingLotService parkingLotService = new ParkingLotServiceImpl(parkingFloorRepo, parkingLotRepo, parkingLotGateRepo, parkingSpotRepo);
        TicketService ticketService = new TicketServiceImpl(parkingLotRepo, parkingLotGateRepo, ticketRepo);

        // Created Controller.
        ParkingLotController parkingLotController = new ParkingLotController(parkingLotService);
        TicketController ticketController = new TicketController(ticketService);


        //Call the controller method.
        parkingLotController.createParkingLot(createNewParkingLot());
        System.out.println("ParkingLot is created. Now generating ticket: ");
        
        // call the controller method.
        TicketResponseDTO ticketDTO =  ticketController.generateTicket(new GenerateTicketDTO(1L,1L,
                new Vehicle("KA1234", VehicleType.FOUR_WHEELER)));
        System.out.println("TicketNumber: " + ticketDTO.getNumber());

    }

    /**
     * 
     * This functions.
     * @return
     */
    private static CreateParkingLotRequestDTO createNewParkingLot() {
        CreateParkingLotRequestDTO requestDTO = new CreateParkingLotRequestDTO();
        requestDTO.setFeesCalculatorStrategyType(FeesCalculatorStrategyType.STATIC);
        requestDTO.setParkingFloors(createParkingFloor());
        requestDTO.setParkingLotGates(createNewGate());
        requestDTO.setParkingLotStatus(ParkingLotStatus.OPEN);
        requestDTO.setSpotAssignmentStrategyType(SpotAssignmentStrategyType.ASSIGN_FIRST_EMPTY);
        return requestDTO;
    }


    private static List<ParkingFloorDTO> createParkingFloor() {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new ParkingSpot(1));
        return Arrays.asList(new ParkingFloorDTO(parkingSpots, "F1"));
    }

    private static List<ParkingLotGateDTO> createNewGate() {
        return Arrays.asList(new ParkingLotGateDTO(GateType.ENTRY,1, new Operator(100, " Yash"), GateStatus.OPEN));
    }
}
