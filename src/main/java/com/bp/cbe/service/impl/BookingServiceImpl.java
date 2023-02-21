package com.bp.cbe.service.impl;

import com.bp.cbe.domain.Booking;
import com.bp.cbe.domain.dto.BillboardDto;
import com.bp.cbe.domain.dto.BookingDto;
import com.bp.cbe.domain.dto.MovieGenreAndDateRequestDto;
import com.bp.cbe.domain.dto.SeatDto;
import com.bp.cbe.domain.enums.MovieGenreEnum;
import com.bp.cbe.repository.BookingRepository;
import com.bp.cbe.service.BookingService;
import com.bp.cbe.service.mapper.BookingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public List<BookingDto> listAll() {
        return bookingRepository.findAll().stream().map(bookingMapper::toBookingDto).toList();
    }

    @Override
    public BookingDto findById(Integer id) {
        return bookingRepository.findById(id).map(bookingMapper::toBookingDto)
                .orElseThrow(() -> new NoSuchElementException("Booking not found id " + id));
    }

    @Override
    public BookingDto create(BookingDto t) {
        Booking entity = bookingMapper.toBooking(t);
        return bookingMapper.toBookingDto(bookingRepository.save(entity));
    }

    @Override
    public BookingDto update(BookingDto t) {
        if (bookingRepository.existsById(t.getId())) {
            Optional<Booking> optional = bookingRepository.findById(t.getId());
            optional.ifPresent(entity -> {
                entity.setDate(t.getDate());
                bookingRepository.save(entity);
            });
            return t;
        } else {
            throw new NoSuchElementException("Booking not found id " + t.getId());
        }
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<BookingDto> findByMovieGenreAndDate(MovieGenreAndDateRequestDto movieGenreAndDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookingDto cancelByDisabledSeat(SeatDto disabledSeat) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookingDto cancelByCanceledBillboard(BillboardDto canceledBillboard) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookingDto> findByGenreAndDates(LocalDateTime startDate, LocalDateTime endDate) {
        return bookingRepository.findAllByGenreAndDates(MovieGenreEnum.HORROR, startDate, endDate).stream()
                .map(bookingMapper::toBookingDto).toList();
    }
}
