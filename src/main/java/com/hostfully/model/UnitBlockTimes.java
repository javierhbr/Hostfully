package com.hostfully.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "unit_block_times")
public class UnitBlockTimes {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "unit_id", referencedColumnName = "id")
  private Unit unit;

  @Column(name = "start_time")
  private LocalDate startTime;

  @Column(name = "end_time")
  private LocalDate endTime;

  @Column(name = "reason")
  private String reason;

  @Column(name = "block_status")
  @Enumerated(EnumType.STRING)
  private BlockStatus blockStatus;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public UnitBlockTimes(UUID id, Unit unit, LocalDate startTime, LocalDate endTime, String reason, BlockStatus blockStatus, LocalDateTime updatedAt) {
    this.id = id;
    this.unit = unit;
    this.startTime = startTime;
    this.endTime = endTime;
    this.reason = reason;
    this.blockStatus = blockStatus;
    this.updatedAt = updatedAt;
  }

  public UnitBlockTimes() {

  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
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

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public BlockStatus getBlockStatus() {
    return blockStatus;
  }

  public void setBlockStatus(BlockStatus blockStatus) {
    this.blockStatus = blockStatus;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
