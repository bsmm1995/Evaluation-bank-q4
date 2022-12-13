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

import com.bp.cbe.service.CustomerService;
import com.bp.cbe.service.dto.CustomerDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cinema-booking/api/v1/clients")
@AllArgsConstructor
public class CustomerController {

	private CustomerService customerService;

	@GetMapping
	public ResponseEntity<List<CustomerDto>> list() throws Exception {
		return new ResponseEntity<>(customerService.listAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> findById(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CustomerDto> create(@RequestBody @Valid CustomerDto customerDto) throws Exception {
		CustomerDto createdClient = customerService.create(customerDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdClient.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<CustomerDto> edit(@RequestBody @Valid CustomerDto customerDto) throws Exception {
		return new ResponseEntity<>(customerService.edit(customerDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerDto> delete(@PathVariable("id") Integer id) throws Exception {
		customerService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
