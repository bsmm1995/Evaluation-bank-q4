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

import com.bp.cbe.service.SeatService;
import com.bp.cbe.service.dto.SeatDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cinema-booking/api/v1/seats")
@AllArgsConstructor
public class SeatController {

	private SeatService seatService;

	@GetMapping
	public ResponseEntity<List<SeatDto>> list() throws Exception {
		return new ResponseEntity<>(seatService.listAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SeatDto> findById(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(seatService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<SeatDto> create(@RequestBody @Valid SeatDto seatDto) throws Exception {
		SeatDto createdClient = seatService.create(seatDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdClient.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<SeatDto> edit(@RequestBody @Valid SeatDto seatDto) throws Exception {
		return new ResponseEntity<>(seatService.edit(seatDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<SeatDto> delete(@PathVariable("id") Integer id) throws Exception {
		seatService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
