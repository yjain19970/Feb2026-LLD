package model;

public class Operator extends BaseModel {
    private int empID;
    private String name;
    
    public Operator(int empID, String name) {
        this.empID = empID;
        this.name = name;
    }
    public int getEmpID() {
        return empID;
    }
    public void setEmpID(int empID) {
        this.empID = empID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
