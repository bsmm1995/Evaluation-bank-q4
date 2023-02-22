package com.bp.cbe.service.impl;

import com.bp.cbe.domain.dto.SeatDto;
import com.bp.cbe.domain.entity.BookingEntity;
import com.bp.cbe.domain.entity.SeatEntity;
import com.bp.cbe.repository.BookingRepository;
import com.bp.cbe.repository.SeatRepository;
import com.bp.cbe.service.SeatService;
import com.bp.cbe.service.mapper.SeatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    private final SeatMapper seatMapper;

    @Override
    public List<SeatDto> listAll() {
        return seatRepository.findAll().stream().map(seatMapper::toSeatDto).toList();
    }

    @Override
    public SeatDto findById(Integer id) {
        return seatMapper.toSeatDto(seatRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Seat not found id " + id)));
    }

    @Override
    public SeatDto create(SeatDto seatDto) {
        SeatEntity createdSeat = seatRepository.save(seatMapper.toSeat(seatDto));
        return seatMapper.toSeatDto(createdSeat);
    }

    @Override
    public SeatDto update(SeatDto seatDto) {
        Optional<SeatEntity> optional = seatRepository.findById(seatDto.getId());
        if (optional.isPresent()) {
            var entity = optional.get();
            entity.setNumber(seatDto.getNumber());
            return seatMapper.toSeatDto(seatRepository.save(entity));
        } else {
            throw new NoSuchElementException("Room not found id " + seatDto.getId());
        }
    }

    @Override
    public void delete(Integer id) {
        seatRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void inhabilite(Integer id) {
        seatRepository.findById(id).ifPresent(seat -> {
            seat.setStatus(Boolean.FALSE);
            seatRepository.save(seat);
            List<BookingEntity> bookings = bookingRepository.findAllBySeat(seat);
            for (var booking : bookings) {
                booking.setStatus(Boolean.FALSE);
            }
            bookingRepository.saveAll(bookings);
        });
    }
}
