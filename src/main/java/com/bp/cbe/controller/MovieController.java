package com.bp.cbe.controller;

import com.bp.cbe.service.MovieService;
import com.bp.cbe.domain.dto.MovieDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cinema-booking/api/v1/movies")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> list() {
        return ResponseEntity.ok(movieService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MovieDto> create(@RequestBody @Valid MovieDto movieDto) {
        MovieDto createdClient = movieService.create(movieDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdClient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<MovieDto> edit(@RequestBody @Valid MovieDto movieDto) {
        return ResponseEntity.ok(movieService.update(movieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable("id") Integer id) {
        movieService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
