package dto;

import java.util.List;

import model.enums.FeesCalculatorStrategyType;
import model.enums.ParkingLotStatus;
import model.enums.SpotAssignmentStrategyType;

public class CreateParkingLotRequestDTO {
    private List<ParkingFloorDTO> parkingFloors;
    private List<GateDTO> parkingLotGates;
    private ParkingLotStatus parkingLotStatus;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;
    private FeesCalculatorStrategyType feesCalculatorStrategyType;
    
    public CreateParkingLotRequestDTO(List<ParkingFloorDTO> parkingFloors, List<GateDTO> parkingLotGates,
            ParkingLotStatus parkingLotStatus, SpotAssignmentStrategyType spotAssignmentStrategyType,
            FeesCalculatorStrategyType feesCalculatorStrategyType) {
        this.parkingFloors = parkingFloors;
        this.parkingLotGates = parkingLotGates;
        this.parkingLotStatus = parkingLotStatus;
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
        this.feesCalculatorStrategyType = feesCalculatorStrategyType;
    }
    public List<ParkingFloorDTO> getParkingFloors() {
        return parkingFloors;
    }
    public void setParkingFloors(List<ParkingFloorDTO> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
    public List<GateDTO> getParkingLotGates() {
        return parkingLotGates;
    }
    public void setParkingLotGates(List<GateDTO> parkingLotGates) {
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
