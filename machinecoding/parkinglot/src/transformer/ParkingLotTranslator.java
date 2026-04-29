package transformer;

import java.util.ArrayList;
import java.util.List;

import dto.CreateParkingLotRequestDTO;
import dto.CreateParkingLotResponseDTO;
import dto.ParkingFloorDTO;
import dto.ParkingLotGateDTO;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingLotGate;



public class ParkingLotTranslator {
    
    public static List<ParkingFloor> transform(List<ParkingFloorDTO> floors){
        List<ParkingFloor> response = new ArrayList<>();
        for(ParkingFloorDTO floor: floors){
            ParkingFloor parkingFloor = new ParkingFloor(floor.getParkingSpot(), "F1");
            response.add(parkingFloor);
        }
        return response;
    }

    public static List<ParkingLotGate> transformGate(List<ParkingLotGateDTO> gates){
        List<ParkingLotGate> response = new ArrayList<>();
        for(ParkingLotGateDTO floor: gates){
            ParkingLotGate parkingFloor = new ParkingLotGate(null, null, null) ;
            response.add(parkingFloor);
        }
        return response;
    }

    public static CreateParkingLotResponseDTO transformParkingLot(ParkingLot createdParkingLot, CreateParkingLotRequestDTO requestDTO) {
        CreateParkingLotResponseDTO responseDTO = new CreateParkingLotResponseDTO();
        responseDTO.setParkingLotId(createdParkingLot.getId());
        responseDTO.setRequestDTO(requestDTO);
        return responseDTO;
    }    
}
