package parkinglot.src.service;

import java.util.List;

import parkinglot.src.model.ParkingFloor;
import parkinglot.src.model.ParkingLot;
import parkinglot.src.model.ParkingLotGate;
import parkinglot.src.model.enums.FeesCalculatorStrategyType;
import parkinglot.src.model.enums.ParkingLotStatus;
import parkinglot.src.model.enums.SpotAssignmentStrategyType;

public interface ParkingLotService {
    public ParkingLot createParkingLot(List<ParkingFloor> parkingFloors, List<ParkingLotGate> parkingLotGates,
        ParkingLotStatus parkingLotStatus, SpotAssignmentStrategyType spotAssignmentStrategyType,
        FeesCalculatorStrategyType feesCalculatorStrategyType
    );
}
