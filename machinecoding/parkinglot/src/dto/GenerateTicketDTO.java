package dto;

import model.Vehicle;

public class GenerateTicketDTO {
    private Long gateId;
    private Long parkingLotId;
    private Vehicle vehicle;
    
    

    public GenerateTicketDTO(Long gateId, Long parkingLotId, Vehicle vehicle) {
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
        this.vehicle = vehicle;
    }
    public Long getGateId() {
        return gateId;
    }
    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Long getParkingLotId() {
        return parkingLotId;
    }
    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
    
}
