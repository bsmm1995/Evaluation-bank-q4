package com.bp.cbe.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bp.cbe.service.BookingService;
import com.bp.cbe.service.dto.BillboardDto;
import com.bp.cbe.service.dto.BookingDto;
import com.bp.cbe.service.dto.MovieGenreAndDateRequestDto;
import com.bp.cbe.service.dto.SeatDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {


	@Override
	public List<BookingDto> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDto findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDto create(BookingDto t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDto edit(BookingDto t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<BookingDto> findByMovieGenreAndDate(MovieGenreAndDateRequestDto movieGenreAndDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDto cancelByDisabledSeat(SeatDto disabledSeat) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDto cancelByCanceledBillboard(BillboardDto canceledBillboard) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
