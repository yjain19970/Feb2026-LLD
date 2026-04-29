package repository;

import java.util.HashMap;
import java.util.Map;

import model.ParkingSpot;

public class ParkingSpotRepo {
    private Map<Long, ParkingSpot> parkingFloorRepo;
    private long lastSavedId;

    public ParkingSpotRepo() {
        this.parkingFloorRepo = new HashMap<>();
        this.lastSavedId = 0L;
    }

    public ParkingSpot save(ParkingSpot parkingLot){
        lastSavedId++;

        parkingLot.setId(lastSavedId);
        parkingFloorRepo.put(lastSavedId, parkingLot);
        System.out.println("Saved ParkingSpot with Id: " + lastSavedId);
        return parkingLot;
    }

    public ParkingSpot getById(long id) throws Exception{
        if(!parkingFloorRepo.containsKey(id)){
            throw new Exception();
        }
        return parkingFloorRepo.get(id);
    }       
}
