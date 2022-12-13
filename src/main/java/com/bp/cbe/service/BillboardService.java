package com.bp.cbe.service;

import java.util.List;

import com.bp.cbe.exception.BillboardCancelLowerDateException;
import com.bp.cbe.service.dto.BillboardDto;
import com.bp.cbe.service.dto.BusyAndAvaliableSeatsRequestDto;
import com.bp.cbe.service.dto.BusyAndAvaliableSeatsResponseDto;

public interface BillboardService extends GenericCrudService<BillboardDto, Integer> {

	/**
	 * Refers to item 2.b of the assessment test
	 * 
	 * @param fiter
	 * @return
	 */
	public List<BusyAndAvaliableSeatsResponseDto> listBusyAndAvaliableSeatsByRoomAndDate(
			BusyAndAvaliableSeatsRequestDto fiter) throws Exception;

	/**
	 * Refers to item 3.c of the assessment test
	 * 
	 * @param billboard
	 * @throws BillboardCancelLowerDateException
	 */
	public void cancelBillboard(BillboardDto billboard) throws BillboardCancelLowerDateException, Exception;

}
