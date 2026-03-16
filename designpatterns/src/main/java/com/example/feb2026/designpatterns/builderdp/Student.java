package com.example.feb2026.designpatterns.builderdp;

public class Student {
    private String name;
    private int age;
    private double psp;
    private String univName;
    private String batchName;
    private long id;
    private int gradYear;
    private String phoneNo;

    

    private Student(StudentBuilder input) throws Exception{
       this.name = input.name;
       this.age = input.age;
       this.id = input.id;
       this.phoneNo = input.phoneNo;
    }
    
    public static StudentBuilder getBuilder(){
        return new StudentBuilder();
    }


    static class StudentBuilder {
        String name;
        int age;
        double psp;
        String univName;
        String batchName;
        long id;
        int gradYear;
        String phoneNo;
    // Setters
        public StudentBuilder setBatchName(String batchName) {
            this.batchName = batchName;
            return this;
        }
        public StudentBuilder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }  
        public StudentBuilder setId(long id) {
            this.id = id;
            return this;
        }    
        public StudentBuilder setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }
        public StudentBuilder setPsp(double psp) {
            this.psp = psp;
            return this;
        }
        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }      
        public StudentBuilder setUnivName(String univName) {
        this.univName = univName;
        return this;
    }    
    
    
        public Student build() throws Exception{
            // Add all the validations here.....
            if(this.age <18){
                throw new Exception("Age is less than 18....");
            }
            
            // return this;


            return new Student(this); // now I am able to access Private constructor...
        }    
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getPsp() {
        return psp;
    }
    public void setPsp(double psp) {
        this.psp = psp;
    }
    public String getUnivName() {
        return univName;
    }
    public void setUnivName(String univName) {
        this.univName = univName;
    }
    public String getBatchName() {
        return batchName;
    }
    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getGradYear() {
        return gradYear;
    }
    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }    

}
