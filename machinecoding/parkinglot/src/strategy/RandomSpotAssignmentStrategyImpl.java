package strategy;

import exception.SpotNotFoundException;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;
import model.enums.ParkingSpotStatus;

public class RandomSpotAssignmentStrategyImpl implements SpotAssignmentStrategy {

    @Override
    public ParkingSpot findParkingSpot(Vehicle vehicle, ParkingLot parkingLot) throws SpotNotFoundException {
        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()){
            for(ParkingSpot spot : parkingFloor.getParkingSpot()){
                if(spot.getSupportedVehicleTypes().contains(vehicle.getVehicleType()) && 
                    spot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)){
                        System.out.println("Spot is assigned.... "+ spot.getId());
                        return spot;
                    }
            }
        }
        throw new SpotNotFoundException("Parking lot is full...");
    }
    
}
