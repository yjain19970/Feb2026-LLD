package strategy;

import java.util.Optional;

import model.ParkingLot;
import model.ParkingSpot;
import model.enums.VehicleType;

public class ManualSpotAssignmentStrategy implements SpotAssignmentStrategy {

    @Override
    public Optional<ParkingSpot> findParkingSpot(ParkingLot parkingLot, VehicleType vehicleType) {
       return null;
    }
    
}
