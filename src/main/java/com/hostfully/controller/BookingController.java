package com.hostfully.controller;

import com.hostfully.dto.BookingDeleteResponse;
import com.hostfully.dto.BookingDto;
import com.hostfully.dto.CreateBookingDto;
import com.hostfully.dto.ListBookingResponseDto;
import com.hostfully.exception.BookingException;
import com.hostfully.services.BookingService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public BookingDto createBooking(@RequestBody CreateBookingDto booking) throws BookingException {
        return this.bookingService.createBooking(booking);
    }

    @PatchMapping("/{bookingId}")
    public BookingDto updateBooking(
            @PathVariable("bookingId") UUID bookingId,
            @RequestBody CreateBookingDto booking
    ) throws BookingException {
        return this.bookingService.updateBooking(bookingId, booking);
    }

    @DeleteMapping("/{id}")
    public BookingDeleteResponse deleteBooking(@PathVariable("id") UUID bookingId) throws BookingException {
        return this.bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/{id}/")
    public ListBookingResponseDto getBookingDetails(@PathVariable("id") UUID bookingId) {
        return bookingService.getBookingDetails(bookingId);
    }

    @GetMapping("/unit/{id}/")
    public ListBookingResponseDto getBookingOfUnit(
            @PathVariable("id") UUID id,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return bookingService.getUnitBookings(id, pageNo, pageSize);
    }
}
