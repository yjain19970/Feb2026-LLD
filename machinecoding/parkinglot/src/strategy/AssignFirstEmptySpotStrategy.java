package strategy;

import java.util.Optional;

import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.enums.ParkingSpotStatus;
import model.enums.VehicleType;

public class AssignFirstEmptySpotStrategy implements SpotAssignmentStrategy {

    @Override
    public Optional<ParkingSpot> findParkingSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        System.out.println("Size of floors: " + parkingLot.getParkingFloors().size());
       for(ParkingFloor floor: parkingLot.getParkingFloors()){
        System.out.println("ParkingSpot size in the floor: " + floor.getParkingSpot());
            for(ParkingSpot spot : floor.getParkingSpot()){
                
                if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY) &&
                     spot.getSupportedVehicleTypes().contains(vehicleType)){
                        System.out.println("Found the parking spot!:  " + spot.getSpotNumber());
                        return Optional.of(spot);
                }
            }
       }
       return Optional.empty();
    }
    
}
