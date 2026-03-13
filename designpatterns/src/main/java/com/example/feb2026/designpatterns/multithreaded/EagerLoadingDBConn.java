package com.example.feb2026.designpatterns.multithreaded;

public class EagerLoadingDBConn {
    private static EagerLoadingDBConn INSTANCE = new EagerLoadingDBConn();
    private String url;
    private String username;
    private String pwd;

    private EagerLoadingDBConn() {
    }

    public static EagerLoadingDBConn createInstance() {
        return INSTANCE;
    }
}
