package com.example.feb2026.designpatterns.builderdp;

public class Client {
    public static void main(String[] args) throws Exception {
        Student yashSt =  Student.getBuilder()
        .setAge(20)
        .setBatchName("B1")
        .setId(1223L)
        .setName("Yash")
        .build();

        System.out.println("object: " + yashSt);

        //yashSt.setAge(10000);

    }
}
