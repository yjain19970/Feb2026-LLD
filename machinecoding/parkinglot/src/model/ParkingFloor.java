package model;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private List<ParkingSpot> parkingSpot;
    private String floorNumber;
    
    
    public ParkingFloor(List<ParkingSpot> parkingSpot, String floorNumber) {
        this.parkingSpot = parkingSpot;
        this.floorNumber = floorNumber;
    }
    public List<ParkingSpot> getParkingSpot() {
        return parkingSpot;
    }
    public void setParkingSpot(List<ParkingSpot> parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
    public String getFloorNumber() {
        return floorNumber;
    }
    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    
}
