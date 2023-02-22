package com.bp.cbe.service.mapper;

import com.bp.cbe.domain.entity.RoomEntity;
import com.bp.cbe.domain.dto.RoomDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomEntity toRoom(RoomDto roomDto);

    RoomDto toRoomDto(RoomEntity room);
}
