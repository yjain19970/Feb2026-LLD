package com.example.scaler.bmsapril26.config;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReentrantLockBean {
    
    @Bean
    public ReentrantLock createLock(){
        return new ReentrantLock();
    }
}
