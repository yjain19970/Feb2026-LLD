package parkinglot.src.model;

import java.util.Arrays;
import java.util.List;

import parkinglot.src.model.enums.ParkingSpotStatus;
import parkinglot.src.model.enums.VehicleType;


public class ParkingSpot extends BaseModel {
    private List<VehicleType> supportedVehicleTypes;
    private ParkingSpotStatus parkingSpotStatus;
    private int spotNumber;
    

    public ParkingSpot(int spotNumber) {
        this.supportedVehicleTypes = Arrays.asList(VehicleType.FOUR_WHEELER);
        this.parkingSpotStatus = ParkingSpotStatus.EMPTY;
        this.spotNumber = spotNumber;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}
