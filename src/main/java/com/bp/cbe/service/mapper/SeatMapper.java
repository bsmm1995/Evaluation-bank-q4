package com.bp.cbe.service.mapper;

import org.mapstruct.Mapper;

import com.bp.cbe.domain.Seat;
import com.bp.cbe.service.dto.SeatDto;

@Mapper(componentModel = "spring", uses = RoomMapper.class)
public interface SeatMapper {

	public Seat toSeat(SeatDto roomDto);

	public SeatDto toSeatDto(Seat room);

}
