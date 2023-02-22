package com.bp.cbe.service.impl;

import com.bp.cbe.domain.entity.Billboard;
import com.bp.cbe.domain.dto.BillboardDto;
import com.bp.cbe.domain.dto.BusyAndAvaliableSeatsRequestDto;
import com.bp.cbe.domain.dto.BusyAndAvaliableSeatsResponseDto;
import com.bp.cbe.domain.interf.BusyAndTotalSeats;
import com.bp.cbe.repository.BillboardRepository;
import com.bp.cbe.service.BillboardService;
import com.bp.cbe.service.mapper.BillboardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillboardServiceImpl implements BillboardService {

    private final BillboardRepository billboardRepository;

    private final BillboardMapper billboardMapper;

    @Override
    public List<BillboardDto> listAll() {
        return billboardRepository.findAll().stream().map(billboardMapper::toBillboardDto)
                .toList();
    }

    @Override
    public BillboardDto findById(Integer id) {
        return billboardMapper.toBillboardDto(billboardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Billboard not found id " + id)));
    }

    @Override
    public BillboardDto create(BillboardDto billboardDto) {
        Billboard createdBillboard = billboardRepository.save(billboardMapper.toBillboard(billboardDto));
        return billboardMapper.toBillboardDto(createdBillboard);
    }

    @Override
    public BillboardDto update(BillboardDto billboardDto) {
        Optional<Billboard> optional = billboardRepository.findById(billboardDto.getId());
        if (optional.isPresent()) {
            var entity = optional.get();
            entity.setDate(billboardDto.getDate());
            return billboardMapper.toBillboardDto(billboardRepository.save(entity));
        } else {
            throw new NoSuchElementException("Billboard not found id " + billboardDto.getId());
        }
    }

    @Override
    public void delete(Integer id) {
        billboardRepository.deleteById(id);
    }

    @Override
    public BusyAndAvaliableSeatsResponseDto listBusyAndAvaliableSeatsByRoomAndDate(BusyAndAvaliableSeatsRequestDto fiter) {
        BusyAndTotalSeats result = billboardRepository.findAllStatusByRoomId(fiter.getIdRoom(), fiter.getBillboardDate());
        int busySeats = result.getBusySeats() != null ? result.getBusySeats() : 0;
        return new BusyAndAvaliableSeatsResponseDto(result.getTotal() - busySeats, busySeats, fiter.getBillboardDate());
    }

    @Override
    public void cancelBillboard(BillboardDto billboard) {
        // TODO Auto-generated method stub
    }
}
