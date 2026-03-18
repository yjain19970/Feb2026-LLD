package com.example.feb2026.designpatterns.builderdp;

import com.example.feb2026.designpatterns.builderdp.Student.StudentBuilder;

public class Client {
    public static void main(String[] args) throws Exception {
        Student yashSt =  Student.getBuilder()
        .setAge(20)
        .setBatchName("B1")
        .setId(1223L)
        .setName("Yash")
        .build();

        StudentBuilder sBuilder = new StudentBuilder();
        sBuilder.setAge(0)
        .setBatchName(null)
        .setName(null)
        .build();        

        System.out.println("object: " + yashSt);

        //yashSt.setAge(10000);

    }
}
