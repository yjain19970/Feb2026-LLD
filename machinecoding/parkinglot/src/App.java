package parkinglot.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parkinglot.src.controller.ParkingLotController;
import parkinglot.src.controller.TicketController;
import parkinglot.src.dto.CreateParkingLotRequestDTO;
import parkinglot.src.model.Operator;
import parkinglot.src.model.ParkingFloor;
import parkinglot.src.model.ParkingLot;
import parkinglot.src.model.ParkingLotGate;
import parkinglot.src.model.ParkingSpot;
import parkinglot.src.model.Vehicle;
import parkinglot.src.model.enums.FeesCalculatorStrategyType;
import parkinglot.src.model.enums.GateStatus;
import parkinglot.src.model.enums.GateType;
import parkinglot.src.model.enums.ParkingLotStatus;
import parkinglot.src.model.enums.SpotAssignmentStrategyType;
import parkinglot.src.model.enums.VehicleType;
import parkinglot.src.repository.ParkingFloorRepo;
import parkinglot.src.repository.ParkingLotGateRepo;
import parkinglot.src.repository.ParkingLotRepo;
import parkinglot.src.service.ParkingLotService;
import parkinglot.src.service.ParkingLotServiceImpl;
import parkinglot.src.service.TicketServiceImpl;



public class App {
    public static void main(String[] args) throws Exception {
        //Created Repository
        ParkingFloorRepo parkingFloorRepo = new ParkingFloorRepo();
        ParkingLotRepo parkingLotRepo = new ParkingLotRepo();
        ParkingLotGateRepo parkingLotGateRepo = new ParkingLotGateRepo();

        //Created Service
        ParkingLotService parkingLotService = new ParkingLotServiceImpl(parkingFloorRepo, parkingLotRepo, parkingLotGateRepo);
        
        // Created Controller.
        ParkingLotController parkingLotController = new ParkingLotController(parkingLotService);


        //Call the controller method.
        parkingLotController.createParkingLot(createNewParkingLot());
    }

    /**
     * 
     * This functions.
     * @return
     */
    private static CreateParkingLotRequestDTO createNewParkingLot() {
        CreateParkingLotRequestDTO requestDTO = new CreateParkingLotRequestDTO();
        requestDTO.setFeesCalculatorStrategyType(FeesCalculatorStrategyType.STATIC);
        requestDTO.setParkingFloors(new ArrayList<>());
        requestDTO.setParkingLotGates(new ArrayList<>());
        requestDTO.setParkingLotStatus(ParkingLotStatus.OPEN);
        requestDTO.setSpotAssignmentStrategyType(SpotAssignmentStrategyType.RANDOM);
        return requestDTO;
    }


    private static ParkingLotGate createNewGate() {
        return new ParkingLotGate(GateType.ENTRY, new Operator(100, " Yash"), GateStatus.OPEN);
    }
}
