package com.bp.cbe.service.mapper;

import org.mapstruct.Mapper;

import com.bp.cbe.domain.Room;
import com.bp.cbe.service.dto.RoomDto;

@Mapper(componentModel = "spring")
public interface RoomMapper {

	public Room toRoom(RoomDto roomDto);

	public RoomDto toRoomDto(Room room);

}
