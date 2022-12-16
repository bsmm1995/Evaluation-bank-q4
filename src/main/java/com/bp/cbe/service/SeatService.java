package com.bp.cbe.service;

import com.bp.cbe.service.dto.SeatDto;

public interface SeatService extends GenericCrudService<SeatDto, Integer> {

    void inhabilite(Integer id);
}
