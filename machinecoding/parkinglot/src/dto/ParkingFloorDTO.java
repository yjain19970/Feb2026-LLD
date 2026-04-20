package parkinglot.src.dto;

import java.util.List;

import model.ParkingSpot;

public class ParkingFloorDTO {
    private List<ParkingSpot> parkingSpot;
    private String floorNumber;
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
