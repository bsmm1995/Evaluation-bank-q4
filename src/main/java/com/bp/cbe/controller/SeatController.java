package com.bp.cbe.controller;

import com.bp.cbe.domain.dto.SeatDto;
import com.bp.cbe.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cinema-booking/api/v1/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @GetMapping
    public ResponseEntity<List<SeatDto>> list() {
        return ResponseEntity.ok(seatService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatDto> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(seatService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SeatDto> create(@RequestBody @Valid SeatDto seatDto) {
        SeatDto createdClient = seatService.create(seatDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdClient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<SeatDto> update(@RequestBody @Valid SeatDto seatDto) {
        return ResponseEntity.ok(seatService.update(seatDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        seatService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/inhabilite/{id}")
    public ResponseEntity<Void> inhabilite(@PathVariable("id") Integer id) {
        seatService.inhabilite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
