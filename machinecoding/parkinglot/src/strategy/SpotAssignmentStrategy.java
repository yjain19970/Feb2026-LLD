package strategy;

import java.util.Optional;

import model.ParkingLot;
import model.ParkingSpot;
import model.enums.VehicleType;

public interface SpotAssignmentStrategy {
    public Optional<ParkingSpot> findParkingSpot(ParkingLot parkingLot, VehicleType vehicleType);
}
