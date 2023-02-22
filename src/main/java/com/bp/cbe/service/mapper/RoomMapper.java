package com.bp.cbe.service.mapper;

import com.bp.cbe.domain.entity.Room;
import com.bp.cbe.domain.dto.RoomDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room toRoom(RoomDto roomDto);

    RoomDto toRoomDto(Room room);
}
