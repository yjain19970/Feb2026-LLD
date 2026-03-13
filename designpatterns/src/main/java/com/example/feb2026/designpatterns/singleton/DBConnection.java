package com.example.feb2026.designpatterns.singleton;

public class DBConnection {
    private static DBConnection INSTANCE = null;
    private String url;
    private String username;
    private String pwd;

    private DBConnection() {
    }
    // Basic Singleton

    public static DBConnection createInstance(){
        if(INSTANCE==null){
            System.out.println("Creating the fresh object....");
            INSTANCE = new DBConnection();
        }
        return INSTANCE;
    }
}
