package com.example.feb2026.designpatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private Map<String,Student> registry = new HashMap<>();

    public void registry(String key, Student studentObjToRegister){
        registry.put(key, studentObjToRegister);
    }

    public Student get(String key){
        if(key.isEmpty()){
            throw new IllegalArgumentException();
        }
        return registry.get(key);
    }

    
    
}
