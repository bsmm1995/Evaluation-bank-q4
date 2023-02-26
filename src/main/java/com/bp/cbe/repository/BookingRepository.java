package com.bp.cbe.repository;

import com.bp.cbe.domain.entity.BookingEntity;
import com.bp.cbe.domain.entity.SeatEntity;
import com.bp.cbe.domain.enums.MovieGenreEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
    @Query(value = """
            SELECT boo.* FROM Booking boo
                        INNER JOIN Billboard bil ON bil.ID = boo.ID_BILLBOARD
                        INNER JOIN Movie mov ON mov.ID = bil.ID_MOVIE
                        WHERE mov.GENRE = :genre
                        AND bil.date BETWEEN :startDate AND :endDate
            """,
            nativeQuery = true)
    List<BookingEntity> findAllByGenreAndDates(MovieGenreEnum genre, LocalDateTime startDate, LocalDateTime endDate);

    List<BookingEntity> findAllBySeat(SeatEntity seat);

    @Modifying
    @Query("UPDATE BOOKING SET status = :status WHERE ID_SEAT = :seat")
    void updateStatusBySeatId(@Param(value = "status") Boolean status, @Param(value = "seat") Integer seat);
}
