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

import com.bp.cbe.service.BookingService;
import com.bp.cbe.service.dto.BookingDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cinema-booking/api/v1/bookings")
@AllArgsConstructor
public class BookingController {

	private BookingService bookingService;

	@GetMapping
	public ResponseEntity<List<BookingDto>> list() throws Exception {
		return new ResponseEntity<>(bookingService.listAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookingDto> findById(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(bookingService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BookingDto> create(@RequestBody @Valid BookingDto bookingDto) throws Exception {
		BookingDto createdClient = bookingService.create(bookingDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdClient.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<BookingDto> edit(@RequestBody @Valid BookingDto bookingDto) throws Exception {
		return new ResponseEntity<>(bookingService.edit(bookingDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BookingDto> delete(@PathVariable("id") Integer id) throws Exception {
		bookingService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
