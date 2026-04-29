package repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import model.ParkingLotGate;


public class ParkingLotGateRepo {
    private Map<Long, ParkingLotGate> parkingLotGateRepo;
    private long lastSavedId;

    public ParkingLotGateRepo() {
        this.parkingLotGateRepo = new HashMap<>();
        this.lastSavedId = 0L;
    }

    public ParkingLotGate save(ParkingLotGate parkingLot){
        lastSavedId++;

        parkingLot.setId(lastSavedId);
        parkingLotGateRepo.put(lastSavedId, parkingLot);
        System.out.println("Saved ParkingLotGate with Id: " + lastSavedId);
        return parkingLot;
    }

    public Optional<ParkingLotGate> getById(long id) throws Exception{
        if(!parkingLotGateRepo.containsKey(id)){
            Optional.empty();
        }
        return Optional.of(parkingLotGateRepo.get(id));
    }    
}
