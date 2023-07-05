package com.hostfully.repository;

import com.hostfully.model.UnitBlockTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface UnitBlockTimeRepository extends JpaRepository<UnitBlockTimes, UUID> {

    @Query("SELECT ub FROM UnitBlockTimes ub " +
            "WHERE ub.unit.id = :unitId " +
            "AND (ub.startTime < :endTime) " +
            "AND (ub.endTime > :startTime)")
    List<UnitBlockTimes> findUnitBlockTimes(
            @Param("unitId") UUID unitId,
            @Param("startTime") LocalDate startTime,
            @Param("endTime") LocalDate endTime
    );
}
