package com.bp.cbe.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bp.cbe.service.RoomService;
import com.bp.cbe.service.dto.RoomDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cinema-booking/api/v1/rooms")
@AllArgsConstructor
public class RoomController {

	private RoomService roomService;

	@GetMapping
	public ResponseEntity<List<RoomDto>> list() throws Exception {
		return new ResponseEntity<>(roomService.listAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RoomDto> findById(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(roomService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<RoomDto> create(@RequestBody @Valid RoomDto roomDto) throws Exception {
		RoomDto createdClient = roomService.create(roomDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdClient.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<RoomDto> edit(@RequestBody @Valid RoomDto roomDto) throws Exception {
		return new ResponseEntity<>(roomService.edit(roomDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<RoomDto> delete(@PathVariable("id") Integer id) throws Exception {
		roomService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
