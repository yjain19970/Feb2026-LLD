package dto;

import model.Operator;
import model.enums.GateStatus;
import model.enums.GateType;

public class ParkingLotGateDTO {
    private GateType gateType; 
    private int gateNumber; 
    private Operator currentOperator; 
    private GateStatus getStatus;
    
    public ParkingLotGateDTO(GateType gateType, int gateNumber, Operator currentOperator, GateStatus getStatus) {
        this.gateType = gateType;
        this.gateNumber = gateNumber;
        this.currentOperator = currentOperator;
        this.getStatus = getStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public GateStatus getGetStatus() {
        return getStatus;
    }

    public void setGetStatus(GateStatus getStatus) {
        this.getStatus = getStatus;
    }
    
}

