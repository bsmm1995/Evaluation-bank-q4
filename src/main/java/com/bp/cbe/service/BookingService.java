package com.bp.cbe.service;

import java.util.List;

import com.bp.cbe.service.dto.BillboardDto;
import com.bp.cbe.service.dto.BookingDto;
import com.bp.cbe.service.dto.MovieGenreAndDateRequestDto;
import com.bp.cbe.service.dto.SeatDto;

public interface BookingService extends GenericCrudService<BookingDto, Integer> {
	/**
	 * Refers to item 2.a of the assessment test
	 * 
	 * @param genre
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<BookingDto> findByMovieGenreAndDate(MovieGenreAndDateRequestDto movieGenreAndDate) throws Exception;

	/**
	 * Refers to item 3.a of the assessment test
	 * 
	 * @param inactiveSeat
	 * @return
	 */
	public BookingDto cancelByDisabledSeat(SeatDto disabledSeat) throws Exception;

	/**
	 * Refers to item 3.b of the assessment test
	 * 
	 * @param canceledBillboard
	 * @return
	 */
	public BookingDto cancelByCanceledBillboard(BillboardDto canceledBillboard) throws Exception;
}
