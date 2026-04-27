package parkinglot.src.service;

import java.util.Arrays;
import java.util.List;

import parkinglot.src.model.ParkingFloor;
import parkinglot.src.model.ParkingLot;
import parkinglot.src.model.ParkingLotGate;
import parkinglot.src.model.enums.FeesCalculatorStrategyType;
import parkinglot.src.model.enums.ParkingLotStatus;
import parkinglot.src.model.enums.SpotAssignmentStrategyType;
import parkinglot.src.model.enums.VehicleType;
import parkinglot.src.repository.ParkingFloorRepo;
import parkinglot.src.repository.ParkingLotGateRepo;
import parkinglot.src.repository.ParkingLotRepo;

public class ParkingLotServiceImpl implements ParkingLotService {
    private ParkingFloorRepo parkingFloorRepo;
    private ParkingLotRepo parkingLotRepo;
    private ParkingLotGateRepo parkingLotGateRepo;
    

    public ParkingLotServiceImpl(ParkingFloorRepo parkingFloorRepo, ParkingLotRepo parkingLotRepo,
            ParkingLotGateRepo parkingLotGateRepo) {
        this.parkingFloorRepo = parkingFloorRepo;
        this.parkingLotRepo = parkingLotRepo;
        this.parkingLotGateRepo = parkingLotGateRepo;
    }


    @Override
    public ParkingLot createParkingLot(List<ParkingFloor> parkingFloors, List<ParkingLotGate> parkingLotGates,
            ParkingLotStatus parkingLotStatus, SpotAssignmentStrategyType spotAssignmentStrategyType,
            FeesCalculatorStrategyType feesCalculatorStrategyType) {
        System.out.println("Inside createParkingLot ServiceImpl -> ");
        // S1. Save the Parking Floor
        for(ParkingFloor parkingFloor : parkingFloors){
            parkingFloorRepo.save(parkingFloor);
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
