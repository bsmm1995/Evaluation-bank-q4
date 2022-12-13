package com.bp.cbe.service.mapper;

import org.mapstruct.Mapper;

import com.bp.cbe.domain.Billboard;
import com.bp.cbe.service.dto.BillboardDto;

@Mapper(componentModel = "spring", uses = { MovieMapper.class, RoomMapper.class })
public interface BillboardMapper {

	public Billboard toBillboard(BillboardDto billboardDto);

	public BillboardDto toBillboardDto(Billboard billboard);

}
