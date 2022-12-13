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

import com.bp.cbe.service.MovieService;
import com.bp.cbe.service.dto.MovieDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cinema-booking/api/v1/movies")
@AllArgsConstructor
public class MovieController {

	private MovieService movieService;

	@GetMapping
	public ResponseEntity<List<MovieDto>> list() throws Exception {
		return new ResponseEntity<>(movieService.listAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDto> findById(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<MovieDto> create(@RequestBody @Valid MovieDto movieDto) throws Exception {
		MovieDto createdClient = movieService.create(movieDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdClient.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<MovieDto> edit(@RequestBody @Valid MovieDto movieDto) throws Exception {
		return new ResponseEntity<>(movieService.edit(movieDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MovieDto> delete(@PathVariable("id") Integer id) throws Exception {
		movieService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
