package inheritance;

// means that Employee is a child of User class.
public class Employee extends User {
    String empId;
    

    // Employee can be created without USER details...
    // If you want to have USER details mandatorily, 
    // then Remove the no-argument constructor from User class.
    public Employee(String empId) {
        this.empId = empId;
    }


    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
    
}
