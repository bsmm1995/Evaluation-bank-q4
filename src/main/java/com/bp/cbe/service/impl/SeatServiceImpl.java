package com.bp.cbe.service.impl;

import com.bp.cbe.domain.Booking;
import com.bp.cbe.domain.Seat;
import com.bp.cbe.repository.BookingRepository;
import com.bp.cbe.repository.SeatRepository;
import com.bp.cbe.service.SeatService;
import com.bp.cbe.service.dto.SeatDto;
import com.bp.cbe.service.mapper.SeatMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {

    private SeatRepository seatRepository;
    private BookingRepository bookingRepository;
    private SeatMapper seatMapper;

    @Override
    public List<SeatDto> listAll() throws Exception {

        return seatRepository.findAll().stream().map(seat -> seatMapper.toSeatDto(seat)).toList();
    }

    @Override
    public SeatDto findById(Integer id) {
        return seatMapper.toSeatDto(seatRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Seat not found id " + id)));
    }

    @Override
    public SeatDto create(SeatDto seatDto) throws Exception {
        Seat createdSeat = seatRepository.save(seatMapper.toSeat(seatDto));
        return seatMapper.toSeatDto(createdSeat);
    }

    @Override
    public SeatDto edit(SeatDto seatDto) throws Exception {
        Seat editedSeat = seatRepository.save(seatMapper.toSeat(seatDto));
        return seatMapper.toSeatDto(editedSeat);
    }

    @Override
    public void delete(Integer id) throws Exception {
        seatRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void inhabilite(Integer id) {
        seatRepository.findById(id).ifPresent(seat -> {
            seat.setStatus(Boolean.FALSE);
            seatRepository.save(seat);
            List<Booking> bookings = bookingRepository.findAllBySeat(seat);
            for (var booking : bookings) {
                booking.setStatus(Boolean.FALSE);
            }
            bookingRepository.saveAll(bookings);
        });
    }
}
