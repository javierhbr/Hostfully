package com.hostfully.repository;

import com.hostfully.model.Unit;
import com.hostfully.dto.UnitDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UnitRepository extends JpaRepository<Unit, UUID> {

  @Query("SELECT new com.hostfully.dto.UnitDto(u.id, u.name) FROM Unit u WHERE 1=1")
  List<UnitDto> findByUnits();

}
