package dto;

import java.util.List;

import model.ParkingSpot;


public class ParkingFloorDTO {
    private List<ParkingSpot> parkingSpot;
    private String floorNumber;
    
    public ParkingFloorDTO(List<ParkingSpot> parkingSpot, String floorNumber) {
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
