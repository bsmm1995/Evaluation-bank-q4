package com.bp.cbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bp.cbe.domain.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
