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

import com.bp.cbe.service.BillboardService;
import com.bp.cbe.service.dto.BillboardDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cinema-booking/api/v1/billboards")
@AllArgsConstructor
public class BillboardController {

	private BillboardService billboardService;

	@GetMapping
	public ResponseEntity<List<BillboardDto>> list() throws Exception {
		return new ResponseEntity<>(billboardService.listAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BillboardDto> findById(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(billboardService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BillboardDto> create(@RequestBody @Valid BillboardDto billboardDto) throws Exception {
		BillboardDto createdBillboardDto = billboardService.create(billboardDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdBillboardDto.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<BillboardDto> edit(@RequestBody @Valid BillboardDto billboardDto) throws Exception {
		return new ResponseEntity<>(billboardService.edit(billboardDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		billboardService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
