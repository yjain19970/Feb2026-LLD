package com.example.feb2026.designpatterns.prototype;

public class Client2 {

    public static void doSomethingClient2(StudentRegistry studentRegistry) {
        Student copyStudent = studentRegistry.get("ORIGINAL_STUDENT").clone();
        System.out.print("Client-2 copyStudent: " + copyStudent.univName);
    }
}
