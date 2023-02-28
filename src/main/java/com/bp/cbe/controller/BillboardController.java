package com.bp.cbe.controller;

import com.bp.cbe.domain.dto.BillboardDto;
import com.bp.cbe.domain.dto.BusyAndAvaliableSeatsRequestDto;
import com.bp.cbe.domain.dto.BusyAndAvaliableSeatsResponseDto;
import com.bp.cbe.service.BillboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cinema-booking/api/v1/billboards")
@RequiredArgsConstructor
public class BillboardController {

    private final BillboardService billboardService;

    @GetMapping
    public ResponseEntity<List<BillboardDto>> list() {
        return ResponseEntity.ok(billboardService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillboardDto> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(billboardService.findById(id));
    }

    @GetMapping("/status")
    public ResponseEntity<BusyAndAvaliableSeatsResponseDto> listBusyAndAvaliableSeatsByRoomAndDate(@Valid BusyAndAvaliableSeatsRequestDto fiter) {
        return ResponseEntity.ok(billboardService.listBusyAndAvaliableSeatsByRoomAndDate(fiter));
    }

    @PostMapping
    public ResponseEntity<BillboardDto> create(@RequestBody @Valid BillboardDto billboardDto) {
        BillboardDto createdBillboardDto = billboardService.create(billboardDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdBillboardDto.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<BillboardDto> update(@RequestBody @Valid BillboardDto billboardDto) {
        return ResponseEntity.ok(billboardService.update(billboardDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        billboardService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
