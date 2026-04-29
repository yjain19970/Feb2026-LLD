package model;

import java.util.Date;

public class Ticket extends BaseModel {
    private String number;
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSpot assignedSpot; 
    private ParkingLotGate generatedAt;
    public Operator generatedBy; // Optional to keep generatedBy here.
    

    public Ticket(String number, Date entryTime, Vehicle vehicle, ParkingSpot assignedSpot, ParkingLotGate generatedAt,
            Operator generatedBy) {
        this.number = number;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.assignedSpot = assignedSpot;
        this.generatedAt = generatedAt;
        this.generatedBy = generatedBy;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Date getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public ParkingSpot getAssignedSpot() {
        return assignedSpot;
    }
    public void setAssignedSpot(ParkingSpot assignedSpot) {
        this.assignedSpot = assignedSpot;
    }
    public ParkingLotGate getGeneratedAt() {
        return generatedAt;
    }
    public void setGeneratedAt(ParkingLotGate generatedAt) {
        this.generatedAt = generatedAt;
    }
    public Operator getGeneratedBy() {
        return generatedBy;
    }
    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    
}
