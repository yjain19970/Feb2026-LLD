package com.example.feb2026.designpatterns.prototype;

/*
    Student
        GeniusStudent
        IntelligentStudent
    

    Usecase: I want to create multiple copies of Students here.

*/
public class Client {
    public static void doSomethingClient(StudentRegistry studentRegistry) {
        // Creating clones using registry DP.
        Student copyStudent = studentRegistry.get("ORIGINAL_STUDENT").clone();
        System.out.println("Client-1: copy: " + copyStudent.univName);
    }
}
