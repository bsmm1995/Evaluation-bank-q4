package com.bp.cbe.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bp.cbe.repository.RoomRepository;
import com.bp.cbe.service.RoomService;
import com.bp.cbe.service.dto.RoomDto;
import com.bp.cbe.service.mapper.RoomMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
	
	private RoomRepository roomRepository;
	private RoomMapper roomMapper;

	@Override
	public List<RoomDto> listAll() throws Exception {
		return roomRepository.findAll().stream().map(room -> roomMapper.toRoomDto(room)).toList();
	}

	@Override
	public RoomDto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomDto create(RoomDto t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomDto edit(RoomDto t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

}
