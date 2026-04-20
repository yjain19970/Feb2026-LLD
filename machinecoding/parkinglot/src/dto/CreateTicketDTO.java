package dto;

import model.Vehicle;

public class CreateTicketDTO {
    private Long id;
    private Vehicle vehicle;
    private Long gateId;
    private Long parkingLotId;
    private Long assignedSpotId;
    
    
    
    
    
    public CreateTicketDTO() {
    }
    public CreateTicketDTO(Vehicle vehicle, Long gateId, Long parkingLotId) {
        this.vehicle = vehicle;
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public long getGateId() {
        return gateId;
    }
    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }
    public Long getParkingLotId() {
        return parkingLotId;
    }
    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getAssignedSpotId() {
        return assignedSpotId;
    }
    public void setAssignedSpotId(Long assignedSpotId) {
        this.assignedSpotId = assignedSpotId;
    }
    

}
