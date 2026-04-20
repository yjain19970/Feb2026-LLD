package parkinglot.src.repository;

import java.util.Map;
import java.util.Optional;

import parkinglot.src.model.ParkingLotGate;


public class GateRepo {
    Map<Long,ParkingLotGate> gateRepoMap; // this id should be increamental.
    /**
     * Long: id of the parkingLot
     * Value: the ParkingLotObject itself.
     */
    private long lastSavedId;


    public GateRepo(Map<Long, ParkingLotGate> gateRepoMap) {
        this.gateRepoMap = gateRepoMap;
        this.lastSavedId = 0L;
    }

    public Optional<ParkingLotGate> getById(Long id){
        if(!gateRepoMap.containsKey(id)){
            return Optional.empty();
        }

        return Optional.of(gateRepoMap.get(id));
    }

    public Optional<ParkingLotGate> createGate(ParkingLotGate parkingLot){
        lastSavedId++;
        
        parkingLot.setId(lastSavedId);
        gateRepoMap.put(lastSavedId, parkingLot);

        return Optional.of(gateRepoMap.get(lastSavedId));
    }     
}
