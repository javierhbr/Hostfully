package com.hostfully.services;

import com.hostfully.dto.*;
import com.hostfully.exception.BookingException;
import com.hostfully.model.Booking;
import com.hostfully.model.Unit;
import com.hostfully.model.UnitBlockTimes;
import com.hostfully.repository.BookingRepository;
import com.hostfully.repository.UnitBlockTimeRepository;
import com.hostfully.repository.UnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UnitRepository unitRepository;
    private final UnitBlockTimeRepository unitBlockTimeRepository;


    public BookingService(BookingRepository bookingRepository, UnitRepository unitRepository, UnitBlockTimeRepository unitBlockTimeRepository) {
        this.bookingRepository = bookingRepository;
        this.unitRepository = unitRepository;
        this.unitBlockTimeRepository = unitBlockTimeRepository;
    }

    public ListBookingResponseDto getUnitBookings(UUID unitId, int pageNumber, int size) {
        Page<Booking> bookings = this.bookingRepository.findAllBookingsByUnitId(unitId, PageRequest.of(pageNumber, size));
        List<BookingDto> bookingDtos = bookings.getContent().stream().map(booking -> new BookingDto(
                booking.getId(),
                booking.getUnitId(),
                booking.getHostId(),
                booking.getGuestId(),
                booking.getStartTime(),
                booking.getEndTime(),
                booking.getTotalNights(),
                booking.getCreatedAt(),
                booking.getUpdatedAt(),
                null)
        ).toList();
        return new ListBookingResponseDto(bookingDtos, pageNumber, size, bookings.getTotalElements(), bookings.getTotalPages());
    }

    @Transactional
    public ListBookingResponseDto getBookingDetails(UUID bookingId) {
        List<Booking> bookings = this.bookingRepository.getBookingById(bookingId);
        List<BookingDto> bookingDtos = bookings.stream().map(booking -> new BookingDto(
                booking.getId(),
                booking.getUnitId(),
                booking.getHostId(),
                booking.getGuestId(),
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
        return new ListBookingResponseDto(bookingDtos, 0, 20, 0, 0);
    }

    public BookingDto createBooking(CreateBookingDto booking) throws BookingException {

        Unit unitDetails = this.unitRepository.findById(booking.unitId()).orElseThrow(() -> new BookingException("Cannot find unit to book"));
        this.checkForBlockTime(unitDetails, booking);
        this.checkForPreviouslyBooked(unitDetails, booking);

        var totalNights = booking.startTime().until(booking.endTime(), ChronoUnit.DAYS);

        var savedBooking =this.bookingRepository.save(new Booking(
                UUID.randomUUID(),
                unitDetails.getId(),
                unitDetails.getHostId(),
                booking.guestId(),
                booking.startTime(),
                booking.endTime(),
                (int) totalNights,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null
        ));
        return new BookingDto(
                savedBooking.getId(),
                savedBooking.getUnitId(),
                savedBooking.getHostId(),
                savedBooking.getGuestId(),
                savedBooking.getStartTime(),
                savedBooking.getEndTime(),
                savedBooking.getTotalNights(),
                savedBooking.getCreatedAt(),
                savedBooking.getUpdatedAt(),
                null
        );
    }

    private boolean checkForPreviouslyBooked(Unit unitDetails, CreateBookingDto booking) throws BookingException {
        List<Booking> bookings = this.bookingRepository.findOverlappingBookings(unitDetails.getId(), booking.startTime(), booking.endTime());
        if (bookings.isEmpty()) {
            return true;
        } else {
            throw new BookingException("Property already booked for this time");
        }
    }

    private boolean checkForBlockTime(Unit unitDetails, CreateBookingDto booking) throws BookingException {
        List<UnitBlockTimes> unitBlockTimes = this.unitBlockTimeRepository.findUnitBlockTimes(unitDetails.getId(), booking.startTime(), booking.endTime());
        if (unitBlockTimes.isEmpty()) {
            return true;
        } else {
            throw new BookingException("Booking time is not available");
        }
    }

    public BookingDeleteResponse deleteBooking(UUID bookingId) throws BookingException {
        try {
            this.bookingRepository.deleteById(bookingId);
        }catch (Exception e){
            throw new BookingException("Cannot delete booking");
        }
        return new BookingDeleteResponse(bookingId);
    }

    public BookingDto updateBooking(UUID bookingId, CreateBookingDto booking) throws BookingException {
        var bookingDetails = this.bookingRepository.findById(bookingId).orElseThrow(() -> new BookingException("Cannot find booking to update"));
        var unitDetails = this.unitRepository.findById(booking.unitId()).orElseThrow(() -> new BookingException("Cannot find unit to re-book"));

        this.checkForBlockTime(unitDetails, booking);
        this.checkForPreviouslyBookedForUpdate(bookingDetails);
        var totalNights = booking.startTime().until(booking.endTime(), ChronoUnit.DAYS);

        bookingDetails.setStartTime(booking.startTime());
        bookingDetails.setEndTime(booking.endTime());
        bookingDetails.setTotalNights((int) totalNights);
        bookingDetails.setUpdatedAt(LocalDateTime.now());
        this.bookingRepository.save(bookingDetails);
        return new BookingDto(
                bookingDetails.getId(),
                bookingDetails.getUnitId(),
                bookingDetails.getHostId(),
                bookingDetails.getGuestId(),
                bookingDetails.getStartTime(),
                bookingDetails.getEndTime(),
                bookingDetails.getTotalNights(),
                bookingDetails.getCreatedAt(),
                bookingDetails.getUpdatedAt(),
                null
        );
    }

    private void checkForPreviouslyBookedForUpdate(Booking booking) throws BookingException {
        List<Booking> bookings = this.bookingRepository.findOverlappingBookingsIgnoringSelf(booking.getId(), booking.getUnitId(), booking.getStartTime(), booking.getEndTime());
        if (bookings.isEmpty()) {
            return;
        } else {
            throw new BookingException("Property already booked for this time");
        }
    }
}
