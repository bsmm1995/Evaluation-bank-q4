package com.bp.cbe.controller;

import com.bp.cbe.service.RoomService;
import com.bp.cbe.domain.dto.RoomDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cinema-booking/api/v1/rooms")
@AllArgsConstructor
public class RoomController {

    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDto>> list() {
        return ResponseEntity.ok(roomService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(roomService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoomDto> create(@RequestBody @Valid RoomDto roomDto) {
        RoomDto createdClient = roomService.create(roomDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdClient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<RoomDto> update(@RequestBody @Valid RoomDto roomDto) {
        return ResponseEntity.ok(roomService.update(roomDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoomDto> delete(@PathVariable("id") Integer id) {
        roomService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
