package com.bp.cbe.service;

import com.bp.cbe.domain.dto.BillboardDto;
import com.bp.cbe.domain.dto.BusyAndAvaliableSeatsRequestDto;
import com.bp.cbe.domain.dto.BusyAndAvaliableSeatsResponseDto;

public interface BillboardService extends GenericCrudService<BillboardDto, Integer> {
    BusyAndAvaliableSeatsResponseDto listBusyAndAvaliableSeatsByRoomAndDate(BusyAndAvaliableSeatsRequestDto fiter);

    void cancelBillboard(BillboardDto billboard);
}
