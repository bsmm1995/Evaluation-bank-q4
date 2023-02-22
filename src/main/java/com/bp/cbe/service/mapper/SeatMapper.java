package com.bp.cbe.service.mapper;

import com.bp.cbe.domain.entity.Seat;
import com.bp.cbe.domain.dto.SeatDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RoomMapper.class)
public interface SeatMapper {

    Seat toSeat(SeatDto roomDto);

    SeatDto toSeatDto(Seat room);
}
