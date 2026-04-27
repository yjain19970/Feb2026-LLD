package com.example.scaler.bmsapril26.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scaler.bmsapril26.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
