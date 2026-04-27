package parkinglot.src.model;
import java.util.List;

import parkinglot.src.model.enums.FeesCalculatorStrategyType;
import parkinglot.src.model.enums.ParkingLotStatus;
import parkinglot.src.model.enums.SpotAssignmentStrategyType;
import parkinglot.src.model.enums.VehicleType;


public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;
    private List<ParkingLotGate> parkingLotGates;
    private ParkingLotStatus parkingLotStatus;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;
    private FeesCalculatorStrategyType feesCalculatorStrategyType;

    public ParkingLot(List<ParkingFloor> parkingFloors, List<ParkingLotGate> parkingLotGates,
            List<VehicleType> supportedVehicleTypes, ParkingLotStatus parkingLotStatus,
            SpotAssignmentStrategyType spotAssignmentStrategyType,
            FeesCalculatorStrategyType feesCalculatorStrategyType) {
        this.parkingFloors = parkingFloors;
        this.parkingLotGates = parkingLotGates;
        //this.supportedVehicleTypes = supportedVehicleTypes;
        this.parkingLotStatus = parkingLotStatus;
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
        this.feesCalculatorStrategyType = feesCalculatorStrategyType;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<ParkingLotGate> getParkingLotGates() {
        return parkingLotGates;
    }

    public void setParkingLotGates(List<ParkingLotGate> parkingLotGates) {
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
