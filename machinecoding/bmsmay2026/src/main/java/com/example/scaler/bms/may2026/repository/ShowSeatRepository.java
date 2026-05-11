package com.example.scaler.bms.may2026.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scaler.bms.may2026.model.Show;
import com.example.scaler.bms.may2026.model.ShowSeat;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    
    List<ShowSeat> findAllByShow(Show show);
    
}
