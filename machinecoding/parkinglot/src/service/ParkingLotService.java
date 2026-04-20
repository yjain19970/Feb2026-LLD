package service;

import java.util.List;

import model.ParkingFloor;
import model.ParkingLotGate;
import model.enums.FeesCalculatorStrategyType;
import model.enums.ParkingLotStatus;
import model.enums.SpotAssignmentStrategyType;

public interface ParkingLotService {
    public void createParkingLot(List<ParkingFloor> parkingFloors, List<ParkingLotGate> parkingLotGates,
        ParkingLotStatus parkingLotStatus, SpotAssignmentStrategyType spotAssignmentStrategyType,
        FeesCalculatorStrategyType feesCalculatorStrategyType
    );
}
