package com.bp.cbe.service;

import com.bp.cbe.domain.dto.BillboardDto;
import com.bp.cbe.domain.dto.BookingDto;
import com.bp.cbe.domain.dto.MovieGenreAndDateRequestDto;
import com.bp.cbe.domain.dto.SeatDto;
import com.bp.cbe.domain.enums.MovieGenreEnum;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService extends GenericCrudService<BookingDto, Integer> {
    List<BookingDto> findByMovieGenreAndDate(MovieGenreAndDateRequestDto movieGenreAndDate);

    BookingDto cancelByDisabledSeat(SeatDto disabledSeat);

    BookingDto cancelByCanceledBillboard(BillboardDto canceledBillboard);

    List<BookingDto> findByGenreAndDates(MovieGenreEnum genre, LocalDateTime startDate, LocalDateTime endDate);
}
