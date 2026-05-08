package com.example.scaler.bms.may2026.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scaler.bms.may2026.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findAllByEmail(String email);
}
