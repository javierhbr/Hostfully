package com.hostfully.repository;

import com.hostfully.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    @Query("SELECT b FROM Booking b " +
            "WHERE b.unitId = :unitId " +
            "AND (b.startTime <= :endTime) AND (b.endTime >= :startTime)")
    List<Booking> findOverlappingBookings(
            @Param("unitId") UUID unitId,
            @Param("startTime") LocalDate startTime,
            @Param("endTime") LocalDate endTime
    );

    @Query("SELECT b FROM Booking b WHERE b.unitId = :unitId")
    Page<Booking> findAllBookingsByUnitId(@Param("unitId") UUID unitId, final Pageable pageable);

    @Query("SELECT b FROM Booking b WHERE b.id = :bookingId")
    List<Booking> getBookingById(@Param("bookingId") UUID bookingId);


    @Query("SELECT b FROM Booking b " +
            "WHERE b.unitId = :unitId " +
            "AND (b.id <> :bookingId)" +
            "AND (b.startTime <= :endTime) AND (b.endTime >= :startTime)")
    List<Booking> findOverlappingBookingsIgnoringSelf(
            @Param("bookingId") UUID bookingId,
            @Param("unitId") UUID unitId,
            @Param("startTime") LocalDate startTime,
            @Param("endTime") LocalDate endTime);
}
