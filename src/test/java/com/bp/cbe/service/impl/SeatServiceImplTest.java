package com.bp.cbe.service.impl;

import com.bp.cbe.domain.Booking;
import com.bp.cbe.domain.Room;
import com.bp.cbe.domain.Seat;
import com.bp.cbe.repository.BookingRepository;
import com.bp.cbe.repository.SeatRepository;
import com.bp.cbe.service.SeatService;
import com.bp.cbe.domain.dto.SeatDto;
import com.bp.cbe.service.mapper.SeatMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SeatServiceImplTest {
    private SeatService seatService;
    private SeatRepository seatRepository;
    private SeatMapper seatMapper;
    private BookingRepository bookingRepository;

    private final int id = 1;

    private Seat seatEntity;
    private SeatDto seatDto;
    private Booking booking;

    @BeforeEach
    void setUp() {
        seatRepository = mock(SeatRepository.class);
        bookingRepository = mock(BookingRepository.class);
        seatMapper = mock(SeatMapper.class);
        seatService = new SeatServiceImpl(seatRepository, bookingRepository, seatMapper);

        seatEntity = new Seat();
        seatEntity.setId(id);
        seatEntity.setStatus(Boolean.TRUE);
        seatEntity.setNumber((short) 2);
        seatEntity.setRowNumber((short) 5);
        seatEntity.setRoom(new Room());

        seatDto = new SeatDto();
        seatDto.setId(seatEntity.getId());
        seatDto.setStatus(seatEntity.getStatus());
        seatDto.setNumber(seatEntity.getNumber());

        booking = new Booking();
        booking.setStatus(Boolean.TRUE);
    }

    @Test
    void inhabilite() {
        when(seatRepository.findById(id)).thenReturn(Optional.of(seatEntity));
        when(bookingRepository.findAllBySeat(seatEntity)).thenReturn(List.of(booking));
        seatService.inhabilite(id);

        seatEntity.setStatus(Boolean.FALSE);
        when(seatRepository.findById(id)).thenReturn(Optional.of(seatEntity));
        SeatDto dto = seatService.findById(id);
        assertNotNull(dto);
        assertEquals(id, dto.getId());
        assertFalse(dto.getStatus());
    }
}