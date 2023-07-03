package com.hostfully.model;

import jakarta.persistence.*;

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

  @Column(name = "start_time")
  private LocalDateTime startTime;

  @Column(name = "end_time")
  private LocalDateTime endTime;

  @Column(name = "total_nights")
  private int totalNights;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
  private List<BookingChangeLog> changeLog;

  public Booking(UUID id, UUID unitId, LocalDateTime startTime, LocalDateTime endTime, int totalNights, LocalDateTime createdAt, LocalDateTime updatedAt, List<BookingChangeLog> changeLog) {
    this.id = id;
    this.unitId = unitId;
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
