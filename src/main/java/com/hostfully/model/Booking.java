package com.hostfully.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bookings")
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "unit_id")
  private UUID unitId;

  @Column(name = "host_Id")
  private UUID hostId;

  @Column(name = "guest_id")
  private UUID guestId;

  @Column(name = "start_time")
  private LocalDate startTime;

  @Column(name = "end_time")
  private LocalDate endTime;

  @Column(name = "total_nights")
  private int totalNights;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
  private List<BookingChangeLog> changeLog;

  public Booking(UUID id, UUID unitId, UUID hostId, UUID guestId, LocalDate startTime, LocalDate endTime, int totalNights, LocalDateTime createdAt, LocalDateTime updatedAt, List<BookingChangeLog> changeLog) {
    this.id = id;
    this.unitId = unitId;
    this.hostId = hostId;
    this.guestId = guestId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.totalNights = totalNights;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.changeLog = changeLog;
  }

  public Booking() {

  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getUnitId() {
    return unitId;
  }

  public void setUnitId(UUID unitId) {
    this.unitId = unitId;
  }

  public UUID getHostId() {
    return hostId;
  }

  public void setHostId(UUID hostId) {
    this.hostId = hostId;
  }

  public UUID getGuestId() {
    return guestId;
  }

  public void setGuestId(UUID guestId) {
    this.guestId = guestId;
  }

  public LocalDate getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDate startTime) {
    this.startTime = startTime;
  }

  public LocalDate getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDate endTime) {
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

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public List<BookingChangeLog> getChangeLog() {
    return changeLog;
  }

  public void setChangeLog(List<BookingChangeLog> changeLog) {
    this.changeLog = changeLog;
  }
}
