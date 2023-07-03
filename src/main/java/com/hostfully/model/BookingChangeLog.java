package com.hostfully.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "booking_change_log")
public class BookingChangeLog {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "booking_id", referencedColumnName = "id")
  private Booking booking;

  @Column(name = "start_time")
  private LocalDateTime startTime;

  @Column(name = "end_time")
  private LocalDateTime endTime;

  @Column(name = "total_nights")
  private int totalNights;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  public BookingChangeLog(UUID id, Booking booking, LocalDateTime startTime, LocalDateTime endTime, int totalNights, LocalDateTime createdAt) {
    this.id = id;
    this.booking = booking;
    this.startTime = startTime;
    this.endTime = endTime;
    this.totalNights = totalNights;
    this.createdAt = createdAt;
  }

  public BookingChangeLog() {

  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Booking getBooking() {
    return booking;
  }

  public void setBooking(Booking booking) {
    this.booking = booking;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public int getTotalNights() {
    return totalNights;
  }

  public void setTotalNights(int totalNights) {
    this.totalNights = totalNights;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
