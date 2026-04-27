package parkinglot.src.controller;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import parkinglot.src.dto.CreateParkingLotRequestDTO;
import parkinglot.src.dto.CreateParkingLotResponseDTO;
import parkinglot.src.model.ParkingLot;
import parkinglot.src.service.ParkingLotService;
import parkinglot.src.transformer.ParkingLotTranslator;



/**
 * Backend related usecase: support creating of a parking lot.
 * 
 */
public class ParkingLotController {
    private ParkingLotService service;
    
   
    public ParkingLotController(ParkingLotService service) {
        this.service = service;
    }


    public CreateParkingLotResponseDTO createParkingLot(CreateParkingLotRequestDTO requestDTO){
        System.out.println("Inside createParkingLot -> ");
        // S1. Validate the Input
        if(invalidInput(requestDTO)){
            System.out.println("Invalid Input for RequestDTO: " + requestDTO);
            throw new InvalidParameterException();
        }

        // S2. Call the service layer.
        ParkingLot createdParkingLot =  service.createParkingLot(ParkingLotTranslator.transform(requestDTO.getParkingFloors()),
             ParkingLotTranslator.transformGate(requestDTO.getParkingLotGates()),
             requestDTO.getParkingLotStatus(), 
             requestDTO.getSpotAssignmentStrategyType(), 
             requestDTO.getFeesCalculatorStrategyType());

        // S3. Convert ParkingLot to DTO and then return.
        System.out.println("Returning response from controller:  " + createdParkingLot);
        return ParkingLotTranslator.transformParkingLot(createdParkingLot, requestDTO);
    }


    /**
     * Check for nulls / invalid values.
     * @param requestDTO
     * @return
     */
    private boolean invalidInput(CreateParkingLotRequestDTO requestDTO) {
        if(requestDTO==null){
            return true;
        }
        return false;
    }
}