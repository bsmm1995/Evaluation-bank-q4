package com.bp.cbe.service.impl;

import com.bp.cbe.domain.dto.RoomDto;
import com.bp.cbe.domain.entity.RoomEntity;
import com.bp.cbe.repository.RoomRepository;
import com.bp.cbe.service.RoomService;
import com.bp.cbe.service.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public List<RoomDto> listAll() {
        return roomRepository.findAll().stream().map(roomMapper::toRoomDto).toList();
    }

    @Override
    public RoomDto findById(Integer id) {
        return roomRepository.findById(id).map(roomMapper::toRoomDto).orElseThrow(() -> new NoSuchElementException("Room not found id " + id));
    }

    @Override
    public RoomDto create(RoomDto t) {
        RoomEntity room = roomMapper.toRoom(t);
        return roomMapper.toRoomDto(roomRepository.save(room));
    }

    @Override
    public RoomDto update(RoomDto t) {
        Optional<RoomEntity> optional = roomRepository.findById(t.getId());
        if (optional.isPresent()) {
            var entity = optional.get();
            entity.setName(t.getName());
            return roomMapper.toRoomDto(roomRepository.save(entity));
        } else {
            throw new NoSuchElementException("Room not found id " + t.getId());
        }
    }

    @Override
    public void delete(Integer id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Room not found id " + id);
        }
    }
}
