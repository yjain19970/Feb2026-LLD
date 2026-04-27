package parkinglot.src.repository;

import java.util.HashMap;
import java.util.Map;

import parkinglot.src.model.ParkingLot;

public class ParkingLotRepo {
    private Map<Long, ParkingLot> parkingLotRepo;
    private long lastSavedId;

    public ParkingLotRepo() {
        this.parkingLotRepo = new HashMap<>();
        this.lastSavedId = 0L;
    }

    public ParkingLot save(ParkingLot parkingLot){
        lastSavedId++;

        parkingLot.setId(lastSavedId);
        parkingLotRepo.put(lastSavedId, parkingLot);
         System.out.println("Saved ParkingLot with Id: " + lastSavedId);
        return parkingLot;
    }

    public ParkingLot getById(long id) throws Exception{
        if(!parkingLotRepo.containsKey(id)){
            throw new Exception();
        }
        return parkingLotRepo.get(id);
    }
    
}
