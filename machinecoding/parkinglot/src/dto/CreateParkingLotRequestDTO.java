package parkinglot.src.dto;

import java.util.List;

import parkinglot.src.model.enums.FeesCalculatorStrategyType;
import parkinglot.src.model.enums.ParkingLotStatus;
import parkinglot.src.model.enums.SpotAssignmentStrategyType;

// DTO is a POJO class.
public class CreateParkingLotRequestDTO {
    private List<ParkingFloorDTO> parkingFloors;
    private List<ParkingLotGateDTO> parkingLotGates;
    private ParkingLotStatus parkingLotStatus;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;
    private FeesCalculatorStrategyType feesCalculatorStrategyType;


    public List<ParkingFloorDTO> getParkingFloors() {
        return parkingFloors;
    }
    public void setParkingFloors(List<ParkingFloorDTO> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
    public List<ParkingLotGateDTO> getParkingLotGates() {
        return parkingLotGates;
    }
    public void setParkingLotGates(List<ParkingLotGateDTO> parkingLotGates) {
        this.parkingLotGates = parkingLotGates;
    }
    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }
    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
    public SpotAssignmentStrategyType getSpotAssignmentStrategyType() {
        return spotAssignmentStrategyType;
    }
    public void setSpotAssignmentStrategyType(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }
    public FeesCalculatorStrategyType getFeesCalculatorStrategyType() {
        return feesCalculatorStrategyType;
    }
    public void setFeesCalculatorStrategyType(FeesCalculatorStrategyType feesCalculatorStrategyType) {
        this.feesCalculatorStrategyType = feesCalculatorStrategyType;
    }

    
}