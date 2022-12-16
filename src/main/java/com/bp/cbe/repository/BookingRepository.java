package com.bp.cbe.repository;

import com.bp.cbe.domain.Booking;
import com.bp.cbe.domain.Seat;
import com.bp.cbe.domain.enums.MovieGenreEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "SELECT boo.* FROM Booking boo " +
            "INNER JOIN Billboard bil ON bil.ID = boo.ID_BILLBOARD " +
            "INNER JOIN Movie mov ON mov.ID = bil.ID_MOVIE " +
            "WHERE mov.GENRE = :genre " +
            "AND bil.date BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<Booking> findAllByGenreAndDates(MovieGenreEnum genre, LocalDateTime startDate, LocalDateTime endDate);

    List<Booking> findAllBySeat(Seat seat);
}
