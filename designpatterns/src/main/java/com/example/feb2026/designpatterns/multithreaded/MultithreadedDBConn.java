package com.example.feb2026.designpatterns.multithreaded;

/**
 * 
 * This is thread safe.
 * 
 * Java ReflectionAPI --> You can actually create multiple objects using that API via this way as well....
 * 
 * 
 * Enum based solution for Singleton in java
 *  -- Highly recommend: to have a look at that as a HW.
 * 
 * 
 * 
 */
public class MultithreadedDBConn {
    private static MultithreadedDBConn INSTANCE = null;
    private String url;
    private String username;
    private String pwd;

    private MultithreadedDBConn() {
    }

    // Multi threaded way of singleton dp.
    public static MultithreadedDBConn createInstance() {
        if(INSTANCE == null){
            synchronized(MultithreadedDBConn.class){
                // This is the 2nd check that we do.
                // Hence called: Double check locking.
                if(INSTANCE ==null){
                    INSTANCE = new MultithreadedDBConn();
                    return INSTANCE;
                }
            }
        }
        return INSTANCE;
    }

    // This is called as DoubleCheckLocking -- because we're checking here two times....
}
