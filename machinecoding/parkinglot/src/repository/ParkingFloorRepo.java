package parkinglot.src.repository;

import java.util.HashMap;
import java.util.Map;

import parkinglot.src.model.ParkingFloor;

public class ParkingFloorRepo {
    private Map<Long, ParkingFloor> parkingFloorRepo;
    private long lastSavedId;

    public ParkingFloorRepo() {
        this.parkingFloorRepo = new HashMap<>();
        this.lastSavedId = 0L;
    }

    public ParkingFloor save(ParkingFloor parkingLot){
        lastSavedId++;

        parkingLot.setId(lastSavedId);
        parkingFloorRepo.put(lastSavedId, parkingLot);
        System.out.println("Saved ParkingFloor with Id: " + lastSavedId);
        return parkingLot;
    }

    public ParkingFloor getById(long id) throws Exception{
        if(!parkingFloorRepo.containsKey(id)){
            throw new Exception();
        }
        return parkingFloorRepo.get(id);
    }        
}
