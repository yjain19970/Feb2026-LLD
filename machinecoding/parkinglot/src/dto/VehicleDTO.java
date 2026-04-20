package parkinglot.src.dto;



public class VehicleDTO {
    private String regNo;
    private VehicleType vehicleType;
    
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
