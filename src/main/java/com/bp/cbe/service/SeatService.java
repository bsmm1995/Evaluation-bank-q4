package com.bp.cbe.service;

import com.bp.cbe.domain.dto.SeatDto;

public interface SeatService extends GenericCrudService<SeatDto, Integer> {

    void inhabilite(Integer id);
}
