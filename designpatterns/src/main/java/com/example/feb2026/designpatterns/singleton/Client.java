package com.example.feb2026.designpatterns.singleton;

public class Client {
    public static void main(String[] args) {
        DBConnection db1 = DBConnection.createInstance();
         DBConnection db2 = DBConnection.createInstance();

        System.out.println("DB1: " + db1);
        System.out.println("DB2: " + db2);
    }   
}
