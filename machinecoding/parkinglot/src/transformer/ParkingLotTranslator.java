package parkinglot.src.transformer;

import java.util.ArrayList;
import java.util.List;

import parkinglot.src.dto.CreateParkingLotRequestDTO;
import parkinglot.src.dto.CreateParkingLotResponseDTO;
import parkinglot.src.dto.ParkingFloorDTO;
import parkinglot.src.dto.ParkingLotGateDTO;
import parkinglot.src.model.ParkingFloor;
import parkinglot.src.model.ParkingLot;
import parkinglot.src.model.ParkingLotGate;

public class ParkingLotTranslator {
    
    public static List<ParkingFloor> transform(List<ParkingFloorDTO> floors){
        List<ParkingFloor> response = new ArrayList<>();
        for(ParkingFloorDTO floor: floors){
            ParkingFloor parkingFloor = new ParkingFloor(null, null);
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
