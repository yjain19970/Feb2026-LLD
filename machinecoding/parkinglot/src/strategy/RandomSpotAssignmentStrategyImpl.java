package strategy;

import java.util.Optional;

import model.ParkingLot;
import model.ParkingSpot;
import model.enums.VehicleType;

public class RandomSpotAssignmentStrategyImpl implements SpotAssignmentStrategy  {

    @Override
    public Optional<ParkingSpot> findParkingSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        /**
         * Find some random SPOT and assign it!
         */
        throw new UnsupportedOperationException("Unimplemented method 'findParkingSpot'");
    }

}
