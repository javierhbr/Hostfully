package com.hostfully.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "units")
public class Unit {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "host_Id")
  private UUID hostId;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit")
  private List<UnitBlockTimes> blockTimes;

  public Unit() {

  }

  public Unit(UUID id, String name, UUID hostId, List<UnitBlockTimes> blockTimes) {
    this.id = id;
    this.name = name;
    this.hostId = hostId;
    this.blockTimes = blockTimes;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UUID getHostId() {
    return hostId;
  }

  public void setHostId(UUID hostId) {
    this.hostId = hostId;
  }

  public List<UnitBlockTimes> getBlockTimes() {
    return blockTimes;
  }

  public void setBlockTimes(List<UnitBlockTimes> blockTimes) {
    this.blockTimes = blockTimes;
  }
}
