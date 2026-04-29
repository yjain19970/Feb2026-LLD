package com.example.scaler.bmsapril26.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scaler.bmsapril26.model.Show;
import com.example.scaler.bmsapril26.model.ShowSeat;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    public List<ShowSeat> findByShow(Show show);
}
