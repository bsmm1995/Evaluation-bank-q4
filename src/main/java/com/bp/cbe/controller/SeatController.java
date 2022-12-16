package com.bp.cbe.controller;

import com.bp.cbe.service.SeatService;
import com.bp.cbe.service.dto.SeatDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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
