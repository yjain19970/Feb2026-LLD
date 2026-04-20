package parkinglot.src.model;



public class Vehicle extends BaseModel {
    private String regNo;
    private VehicleType vehicleType;
    
    public Vehicle(String regNo, VehicleType vehicleType) {
        this.regNo = regNo;
        this.vehicleType = vehicleType;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    
}
