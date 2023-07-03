package com.hostfully.services;

import com.hostfully.dto.BookingChangeLogDto;
import com.hostfully.dto.BookingDto;
import com.hostfully.dto.ListBookingDto;
import com.hostfully.model.Booking;
import com.hostfully.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public ListBookingDto getUnitBookings(UUID unitId, int pageNumber, int size) {
        Page<Booking> bookings = this.bookingRepository.findAllBookingsByUnitId(unitId, PageRequest.of(pageNumber, size));
        List<BookingDto> bookingDtos = bookings.getContent().stream().map(booking -> new BookingDto(
                booking.getId(),
                booking.getUnitId(),
                booking.getStartTime(),
                booking.getEndTime(),
                booking.getTotalNights(),
                booking.getCreatedAt(),
                booking.getUpdatedAt(),
                null)
        ).toList();
        return new ListBookingDto(bookingDtos, pageNumber, size, bookings.getTotalElements(), bookings.getTotalPages());
    }

    @Transactional
    public ListBookingDto getBookingDetails(UUID bookingId) {
        List<Booking> bookings = this.bookingRepository.getBookingById(bookingId);
        List<BookingDto> bookingDtos = bookings.stream().map(booking -> new BookingDto(
                booking.getId(),
                booking.getUnitId(),
                booking.getStartTime(),
                booking.getEndTime(),
                booking.getTotalNights(),
                booking.getCreatedAt(),
                booking.getUpdatedAt(),
                booking.getChangeLog().stream().map(
                        changeLog -> new BookingChangeLogDto(
                                changeLog.getId(),
                                changeLog.getBooking().getId(),
                                changeLog.getStartTime(),
                                changeLog.getEndTime(),
                                changeLog.getTotalNights(),
                                changeLog.getCreatedAt()
                        )
                ).toList()
        )).toList();
        return new ListBookingDto(bookingDtos, 0, 20,0,0);
    }
}
