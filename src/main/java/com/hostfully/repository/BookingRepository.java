package com.hostfully.repository;

import com.hostfully.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

  @Query("SELECT b FROM Booking b " +
          "WHERE (b.startTime < :endTime) AND (b.endTime > :startTime) " +
          "AND (b.id <> :bookingId OR :bookingId IS NULL)")
  List<Booking> findOverlappingBookings(@Param("startTime") LocalDateTime startTime,
                                           @Param("endTime") LocalDateTime endTime,
                                           @Param("bookingId") Long bookingId);

  @Query("SELECT b FROM Booking b WHERE b.unitId = :unitId")
  Page<Booking> findAllBookingsByUnitId(@Param("unitId") UUID unitId, final Pageable pageable);

  @Query("SELECT b FROM Booking b WHERE b.id = :bookingId")
  List<Booking> getBookingById(@Param("bookingId") UUID bookingId);
}
