package com.bp.cbe.service.mapper;

import com.bp.cbe.domain.entity.SeatEntity;
import com.bp.cbe.domain.dto.SeatDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RoomMapper.class)
public interface SeatMapper {

    SeatEntity toSeat(SeatDto roomDto);

    SeatDto toSeatDto(SeatEntity room);
}
