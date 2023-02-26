package com.bp.cbe.repository;

import com.bp.cbe.domain.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, Integer> {
    @Modifying
    @Query("UPDATE SeatEntity SET status = :status WHERE id = :id")
    void updateStatusById(@Param(value = "status") Boolean status, @Param(value = "id") Integer id);
}
