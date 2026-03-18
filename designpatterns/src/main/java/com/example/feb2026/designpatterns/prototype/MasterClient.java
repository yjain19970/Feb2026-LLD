package com.example.feb2026.designpatterns.prototype;

public class MasterClient {
    private static StudentRegistry studentRegistry = new StudentRegistry(); 
    public static void main(String[] args) {
        fillRegistry();
        Client c1 = new Client();
        Client2 c2 = new Client2();

        c1.doSomethingClient(studentRegistry);
        c2.doSomethingClient2(studentRegistry);

    }

    private static void fillRegistry() {
        Student originalStudent = new Student("AnyUniversity", 
        2018, 87.1f,
        "MFW-MORNING");

        IntelligentStudent originaIntelligentStudent = new IntelligentStudent("IntelligentAnyUniversity", 
        2018, 87.1f,
        "MFW-MORNING", 15);

        studentRegistry.registry("ORIGINAL_STUDENT", originalStudent);
        studentRegistry.registry("INTELLIGENT_STUDENT", originaIntelligentStudent);
    }    
}
