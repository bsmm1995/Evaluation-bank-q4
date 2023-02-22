package com.bp.cbe.service.mapper;

import com.bp.cbe.domain.entity.Billboard;
import com.bp.cbe.domain.dto.BillboardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MovieMapper.class, RoomMapper.class})
public interface BillboardMapper {

    Billboard toBillboard(BillboardDto billboardDto);

    BillboardDto toBillboardDto(Billboard billboard);
}
