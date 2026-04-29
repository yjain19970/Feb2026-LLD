package service;

import java.util.Arrays;
import java.util.List;

import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingLotGate;
import model.enums.FeesCalculatorStrategyType;
import model.enums.ParkingLotStatus;
import model.enums.SpotAssignmentStrategyType;
import model.enums.VehicleType;
import repository.ParkingFloorRepo;
import repository.ParkingLotGateRepo;
import repository.ParkingLotRepo;
import repository.ParkingSpotRepo;




public class ParkingLotServiceImpl implements ParkingLotService {
    private ParkingFloorRepo parkingFloorRepo;
    private ParkingLotRepo parkingLotRepo;
    private ParkingLotGateRepo parkingLotGateRepo;
    private ParkingSpotRepo parkingSpotRepo;
    

    public ParkingLotServiceImpl(ParkingFloorRepo parkingFloorRepo, ParkingLotRepo parkingLotRepo,
            ParkingLotGateRepo parkingLotGateRepo, ParkingSpotRepo parkingSpotRepo) {
        this.parkingFloorRepo = parkingFloorRepo;
        this.parkingLotRepo = parkingLotRepo;
        this.parkingLotGateRepo = parkingLotGateRepo;
        this.parkingSpotRepo = parkingSpotRepo;
    }


    @Override
    public ParkingLot createParkingLot(List<ParkingFloor> parkingFloors, List<ParkingLotGate> parkingLotGates,
            ParkingLotStatus parkingLotStatus, SpotAssignmentStrategyType spotAssignmentStrategyType,
            FeesCalculatorStrategyType feesCalculatorStrategyType) {
        System.out.println("Inside createParkingLot ServiceImpl -> ");

        // S1. Save the Parking Floor
        for(ParkingFloor parkingFloor : parkingFloors){
            parkingFloorRepo.save(parkingFloor);
            // In each floor, you will also have to persist all the parkingSpots and then put it inside ParkingSpot
            // so that Id is reflected correctly!
        }

        // S2. Save parkingLotGates
        for(ParkingLotGate parkingLotGate : parkingLotGates){
            parkingLotGateRepo.save(parkingLotGate);
        }

        //S3. Create a parking Lot and save it.
        ParkingLot parkingLot = new ParkingLot(parkingFloors, parkingLotGates, Arrays.asList(VehicleType.FOUR_WHEELER, VehicleType.TWO_WHEELER),
         parkingLotStatus, 
         spotAssignmentStrategyType, 
         feesCalculatorStrategyType);

        ParkingLot createdParkingLot =  parkingLotRepo.save(parkingLot);
        return createdParkingLot;
    }
       
}
