package com.bp.cbe.controller;

import com.bp.cbe.service.BillboardService;
import com.bp.cbe.service.dto.BillboardDto;
import com.bp.cbe.service.dto.BusyAndAvaliableSeatsRequestDto;
import com.bp.cbe.service.dto.BusyAndAvaliableSeatsResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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

    @GetMapping("/status")
    public ResponseEntity<BusyAndAvaliableSeatsResponseDto> listBusyAndAvaliableSeatsByRoomAndDate(BusyAndAvaliableSeatsRequestDto fiter) throws Exception {
        return ResponseEntity.ok(billboardService.listBusyAndAvaliableSeatsByRoomAndDate(fiter));
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
