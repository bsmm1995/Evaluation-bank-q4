package com.bp.cbe.controller;

import com.bp.cbe.domain.dto.BookingDto;
import com.bp.cbe.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cinema-booking/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingDto>> list() {
        return ResponseEntity.ok(bookingService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(bookingService.findById(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<BookingDto>> findByGenreAndDates(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(bookingService.findByGenreAndDates(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<BookingDto> create(@RequestBody @Valid BookingDto bookingDto) {
        BookingDto createdClient = bookingService.create(bookingDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdClient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<BookingDto> update(@RequestBody @Valid BookingDto bookingDto) {
        return ResponseEntity.ok(bookingService.update(bookingDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookingDto> delete(@PathVariable("id") Integer id) {
        bookingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
