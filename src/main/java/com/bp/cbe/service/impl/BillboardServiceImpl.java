package com.bp.cbe.service.impl;

import com.bp.cbe.domain.Billboard;
import com.bp.cbe.domain.interf.BusyAndTotalSeats;
import com.bp.cbe.exception.BillboardCancelLowerDateException;
import com.bp.cbe.repository.BillboardRepository;
import com.bp.cbe.service.BillboardService;
import com.bp.cbe.service.dto.BillboardDto;
import com.bp.cbe.service.dto.BusyAndAvaliableSeatsRequestDto;
import com.bp.cbe.service.dto.BusyAndAvaliableSeatsResponseDto;
import com.bp.cbe.service.mapper.BillboardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BillboardServiceImpl implements BillboardService {

    private BillboardRepository billboardRepository;

    private BillboardMapper billboardMapper;

    @Override
    public List<BillboardDto> listAll() throws Exception {
        return billboardRepository.findAll().stream().map(billboard -> billboardMapper.toBillboardDto(billboard))
                .toList();
    }

    @Override
    public BillboardDto findById(Integer id) throws Exception {

        return billboardMapper.toBillboardDto(billboardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Billboard not found id " + id)));
    }

    @Override
    public BillboardDto create(BillboardDto billboardDto) throws Exception {
        Billboard createdBillboard = billboardRepository.save(billboardMapper.toBillboard(billboardDto));
        return billboardMapper.toBillboardDto(createdBillboard);
    }

    @Override
    public BillboardDto edit(BillboardDto billboardDto) throws Exception {
        Billboard editedBillboard = billboardRepository.save(billboardMapper.toBillboard(billboardDto));
        return billboardMapper.toBillboardDto(editedBillboard);
    }

    @Override
    public void delete(Integer id) throws Exception {
        billboardRepository.deleteById(id);

    }

    @Override
    public BusyAndAvaliableSeatsResponseDto listBusyAndAvaliableSeatsByRoomAndDate(BusyAndAvaliableSeatsRequestDto fiter) {
        BusyAndTotalSeats result = billboardRepository.findAllStatusByRoomId(fiter.getIdRoom(), fiter.getBillboardDate());
        int busySeats = result.getBusySeats() != null ? result.getBusySeats() : 0;
        return new BusyAndAvaliableSeatsResponseDto(result.getTotal() - busySeats, busySeats, fiter.getBillboardDate());
    }

    @Override
    public void cancelBillboard(BillboardDto billboard) throws BillboardCancelLowerDateException, Exception {
        // TODO Auto-generated method stub

    }

}
