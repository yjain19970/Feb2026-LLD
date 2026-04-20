package model;

import java.sql.Date;
import java.util.List;

import model.enums.BillStatus;


public class Bill extends BaseModel {
    private Date exitTime;
    private int amount;
    private Ticket ticket;
    private ParkingLotGate gate;
    private Operator generatedBy;
    private BillStatus billStatus;
    private List<Payment> payments;
    public Date getExitTime() {
        return exitTime;
    }
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public ParkingLotGate getGate() {
        return gate;
    }
    public void setGate(ParkingLotGate gate) {
        this.gate = gate;
    }
    public Operator getGeneratedBy() {
        return generatedBy;
    }
    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }
    public BillStatus getBillStatus() {
        return billStatus;
    }
    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
    public List<Payment> getPayments() {
        return payments;
    }
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    
}
