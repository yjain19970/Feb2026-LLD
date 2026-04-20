package service;

import java.util.List;

import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingLotGate;
import model.enums.FeesCalculatorStrategyType;
import model.enums.ParkingLotStatus;
import model.enums.SpotAssignmentStrategyType;
import repository.ParkingLotRepo;

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
