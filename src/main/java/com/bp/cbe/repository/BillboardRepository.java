package com.bp.cbe.repository;

import com.bp.cbe.domain.Billboard;
import com.bp.cbe.domain.interf.BusyAndTotalSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BillboardRepository extends JpaRepository<Billboard, Integer> {
    @Query(value = "SELECT COUNT(ALL boo.status = 1) AS busySeat, " +
            "(SELECT COUNT(*) FROM Seat s WHERE s.id_room = :roomId) AS total " +
            "FROM Seat sea " +
            "INNER JOIN Booking boo ON boo.id_seat = sea.ID " +
            "INNER JOIN Billboard bil ON bil.ID = boo.id_billboard " +
            "WHERE sea.id_room = :roomId " +
            "AND bil.date = :date",
            nativeQuery = true)
    BusyAndTotalSeats findAllStatusByRoomId(Integer roomId, LocalDate date);
}
