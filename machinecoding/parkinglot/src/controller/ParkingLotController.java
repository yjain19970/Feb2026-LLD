package parkinglot.src.controller;
import java.util.ArrayList;
import java.util.List;



public class ParkingLotController {
    private ParkingLotService parkingLotService;
    
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public void createParkingLot(CreateParkingLotRequestDTO requestDTO){
        parkingLotService.createParkingLot(createParkingFloor(requestDTO.getParkingFloors()), 
        createGates(requestDTO.getParkingLotGates()), 
        requestDTO.getParkingLotStatus(), 
        requestDTO.getSpotAssignmentStrategyType(), 
        requestDTO.getFeesCalculatorStrategyType());   
    }


    public List<ParkingLotGate> createGates(List<GateDTO> gateDTOs){
        List<ParkingLotGate> response = new ArrayList<>();
        for(GateDTO gateDTO: gateDTOs){
            response.add(new ParkingLotGate(gateDTO.getGateType(), gateDTO.getCurrentOperator(), gateDTO.getGetStatus()));
        }
        return response;
    }
    
    public List<ParkingFloor> createParkingFloor(List<ParkingFloorDTO> floorDTOs){
        List<ParkingFloor> response = new ArrayList<>();
        for(ParkingFloorDTO floorDTO: floorDTOs){
            response.add(new ParkingFloor(floorDTO.getParkingSpot(), floorDTO.getFloorNumber()));
        }
        return response;
    }
}
