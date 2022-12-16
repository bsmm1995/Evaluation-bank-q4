package com.bp.cbe.controller;

import com.bp.cbe.service.BookingService;
import com.bp.cbe.service.dto.BookingDto;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/filter")
    public ResponseEntity<List<BookingDto>> findByGenreAndDates(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(bookingService.findByGenreAndDates(startDate, endDate));
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
