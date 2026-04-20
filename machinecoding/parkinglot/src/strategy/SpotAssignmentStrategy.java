package strategy;

import exception.SpotNotFoundException;
import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;

public interface SpotAssignmentStrategy {
    
    public ParkingSpot findParkingSpot(Vehicle vehicle, ParkingLot parkingLot) throws SpotNotFoundException; 
}
