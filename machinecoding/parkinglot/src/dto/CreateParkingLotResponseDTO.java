package parkinglot.src.dto;

public class CreateParkingLotResponseDTO {
    private Long parkingLotId;
    private CreateParkingLotRequestDTO requestDTO;
    
    public Long getParkingLotId() {
        return parkingLotId;
    }
    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
    public CreateParkingLotRequestDTO getRequestDTO() {
        return requestDTO;
    }
    public void setRequestDTO(CreateParkingLotRequestDTO requestDTO) {
        this.requestDTO = requestDTO;
    }
    
}
