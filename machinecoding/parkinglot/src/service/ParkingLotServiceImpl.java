package parkinglot.src.service;
import java.util.List;

import parkinglot.src.model.ParkingFloor;
import parkinglot.src.model.ParkingLot;
import parkinglot.src.model.ParkingLotGate;
import parkinglot.src.model.enums.FeesCalculatorStrategyType;
import parkinglot.src.model.enums.ParkingLotStatus;
import parkinglot.src.model.enums.SpotAssignmentStrategyType;
import parkinglot.src.repository.ParkingLotRepo;


public class ParkingLotServiceImpl implements ParkingLotService {
    private ParkingLotRepo parkingLotRepo;
    

    public ParkingLotServiceImpl(ParkingLotRepo parkingLotRepo) {
        this.parkingLotRepo = parkingLotRepo;
    }


    @Override
    public void createParkingLot(List<ParkingFloor> parkingFloors, List<ParkingLotGate> parkingLotGates,
            ParkingLotStatus parkingLotStatus, SpotAssignmentStrategyType spotAssignmentStrategyType,
            FeesCalculatorStrategyType feesCalculatorStrategyType) {
        parkingLotRepo.saveParkingLot(new ParkingLot(parkingFloors, parkingLotGates,
             null, parkingLotStatus, spotAssignmentStrategyType,
              feesCalculatorStrategyType));

    }
    
}
