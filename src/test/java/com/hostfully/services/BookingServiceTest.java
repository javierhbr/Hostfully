package com.hostfully.services;

import com.hostfully.dto.BookingDto;
import com.hostfully.dto.CreateBookingDto;
import com.hostfully.dto.ListBookingResponseDto;
import com.hostfully.exception.BookingException;
import com.hostfully.model.Booking;
import com.hostfully.model.Unit;
import com.hostfully.repository.BookingRepository;
import com.hostfully.repository.UnitBlockTimeRepository;
import com.hostfully.repository.UnitRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private UnitRepository unitRepository;

    @Mock
    private UnitBlockTimeRepository unitBlockTimeRepository;

    @InjectMocks
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUnitBookings() {
        UUID unitId = UUID.randomUUID();
        int pageNumber = 0;
        int size = 10;

        Page<Booking> mockPage = mock(Page.class);
        List<Booking> mockBookings = new ArrayList<>();
        when(mockPage.getContent()).thenReturn(mockBookings);
        when(mockPage.getTotalElements()).thenReturn((long) mockBookings.size());
        when(mockPage.getTotalPages()).thenReturn(1);
        when(bookingRepository.findAllBookingsByUnitId(eq(unitId), any(PageRequest.class))).thenReturn(mockPage);

        ListBookingResponseDto result = bookingService.getUnitBookings(unitId, pageNumber, size);

        Assertions.assertEquals(mockBookings.size(), result.bookings().size());
    }

    @Test
    void testGetBookingDetails() {
        UUID bookingId = UUID.randomUUID();

        List<Booking> mockBookings = new ArrayList<>();
        when(bookingRepository.getBookingById(eq(bookingId))).thenReturn(mockBookings);

        ListBookingResponseDto result = bookingService.getBookingDetails(bookingId);

        Assertions.assertEquals(mockBookings.size(), result.bookings().size());
    }

    @Test
    void testCreateBooking_Success() throws BookingException {
        UUID unitId = UUID.randomUUID();
        Unit mockUnit = new Unit();
        when(unitRepository.findById(unitId)).thenReturn(java.util.Optional.of(mockUnit));

        when(bookingRepository.findOverlappingBookings(eq(mockUnit.getId()), any(LocalDate.class), any(LocalDate.class))).thenReturn(new ArrayList<>());
        when(bookingRepository.save(any(Booking.class))).thenReturn(new Booking());

        BookingDto result = bookingService.createBooking(new CreateBookingDto(
                unitId,
                UUID.randomUUID(),
                LocalDate.now(),
                LocalDate.now()
        ));

        Assertions.assertNotNull(result);
    }

    @Test
    void testCreateBooking_InvalidUnit_ThrowsException() {
        UUID unitId = UUID.randomUUID();
        when(unitRepository.findById(eq(unitId))).thenReturn(java.util.Optional.empty());

        Assertions.assertThrows(BookingException.class, () -> bookingService.createBooking(
                new CreateBookingDto(
                        UUID.randomUUID(),
                        UUID.randomUUID(),
                        LocalDate.now(),
                        LocalDate.now()
                )));
    }

    @Test
    void testUpdateBooking_Success() throws BookingException {
        UUID bookingId = UUID.randomUUID();
        UUID unitId = UUID.randomUUID();
        LocalDate startTime = LocalDate.now();
        LocalDate endTime = startTime.plusDays(5);

        Booking mockBooking = new Booking();
        when(bookingRepository.findById(eq(bookingId))).thenReturn(Optional.of(mockBooking));
        when(bookingRepository.findOverlappingBookingsIgnoringSelf(eq(bookingId), eq(unitId), any(LocalDate.class), any(LocalDate.class))).thenReturn(new ArrayList<>());
        when(bookingRepository.save(any(Booking.class))).thenReturn(mockBooking);

        Unit mockUnit = new Unit();
        when(unitRepository.findById(eq(unitId))).thenReturn(Optional.of(mockUnit));

        BookingDto result = bookingService.updateBooking(bookingId, new CreateBookingDto(unitId, UUID.randomUUID(), startTime, endTime));

        Assertions.assertNotNull(result);
    }

    @Test
    void testUpdateBooking_BookingNotFound_ThrowsException() {
        UUID bookingId = UUID.randomUUID();
        UUID unitId = UUID.randomUUID();
        LocalDate startTime = LocalDate.now();
        LocalDate endTime = startTime.plusDays(5);

        when(bookingRepository.findById(eq(bookingId))).thenReturn(Optional.empty());

        Assertions.assertThrows(BookingException.class, () -> bookingService.updateBooking(bookingId, new CreateBookingDto(unitId, UUID.randomUUID(), startTime, endTime)));
    }

    @Test
    void testUpdateBooking_UnitNotFound_ThrowsException() {
        UUID bookingId = UUID.randomUUID();
        UUID unitId = UUID.randomUUID();
        LocalDate startTime = LocalDate.now();
        LocalDate endTime = startTime.plusDays(5);

        when(bookingRepository.findById(eq(bookingId))).thenReturn(Optional.of(new Booking()));

        when(unitRepository.findById(eq(unitId))).thenReturn(Optional.empty());
        Assertions.assertThrows(BookingException.class, () -> bookingService.updateBooking(bookingId, new CreateBookingDto(unitId, UUID.randomUUID(), startTime, endTime)));
    }

    @Test
    void testUpdateBooking_PreviouslyBooked_ThrowsException() throws BookingException {
        // Mocking the behavior of the bookingRepository
        UUID bookingId = UUID.randomUUID();
        Booking mockBooking = new Booking();
        mockBooking.setId(bookingId);
        UUID unitId = UUID.randomUUID();
        mockBooking.setUnitId(unitId);
        LocalDate startTime = LocalDate.now().minusDays(1);
        LocalDate endTime = LocalDate.now().plusDays(1);
        mockBooking.setStartTime(startTime);
        mockBooking.setEndTime(endTime);

        when(bookingRepository.findById(eq(bookingId))).thenReturn(Optional.of(mockBooking));
        Unit mockUnit = new Unit();
        when(unitRepository.findById(eq(unitId))).thenReturn(Optional.of(mockUnit));

        List<Booking> overlappingBookings = new ArrayList<>();
        overlappingBookings.add(new Booking());
        when(bookingRepository.findOverlappingBookingsIgnoringSelf(eq(bookingId), eq(unitId), eq(startTime), eq(endTime))).thenReturn(overlappingBookings);

        CreateBookingDto bookingDto = new CreateBookingDto(unitId, UUID.randomUUID(), startTime, endTime);

        Assertions.assertThrows(BookingException.class, () -> bookingService.updateBooking(bookingId, bookingDto));

        verify(bookingRepository, times(1)).findById(eq(bookingId));
        verify(unitRepository, times(1)).findById(eq(unitId));
        verify(bookingRepository, times(1)).findOverlappingBookingsIgnoringSelf(eq(bookingId), eq(unitId), eq(startTime), eq(endTime));
        verify(bookingRepository, never()).save(any());
    }
}