package com.hostfully.controller;

import com.hostfully.dto.BookingDto;
import com.hostfully.dto.ListBookingDto;
import com.hostfully.services.BookingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/bookings")
@Tag(name = "Booking")
public class BookingController implements BookingOpenApi {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody BookingDto booking) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Booking created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBooking(
            @PathVariable("id") long id,
            @RequestBody BookingDto booking
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") long id){
        return null;
    }

    @GetMapping("/{id}/")
    public ListBookingDto getBookingDetails(@PathVariable("id") UUID id) {
        return bookingService.getBookingDetails(id);
    }

    @GetMapping("/unit/{id}/")
    public ListBookingDto getBookingOfUnit(
            @PathVariable("id") UUID id,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return bookingService.getUnitBookings(id, pageNo, pageSize);
    }
}
