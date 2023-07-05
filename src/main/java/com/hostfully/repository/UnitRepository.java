package com.hostfully.repository;

import com.hostfully.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UnitRepository extends JpaRepository<Unit, UUID> {

  @Query("SELECT u FROM Unit u WHERE 1=1")
  List<Unit> findByUnits();

  Unit findUnitByIdEquals( UUID uniId);

}
