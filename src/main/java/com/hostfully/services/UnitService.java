package com.hostfully.services;

import com.hostfully.dto.UnitBlockDto;
import com.hostfully.dto.UnitDto;
import com.hostfully.model.Unit;
import com.hostfully.repository.UnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Transactional
    public List<UnitDto> getAllUnit() {
        List<Unit> units = this.unitRepository.findByUnits();
        return units.stream().map(this::mapUnitToUnitDto).toList();
    }

    @Transactional
    public UnitDto getUnitById(UUID unitId) {
        Unit unit = this.unitRepository.findUnitByIdEquals(unitId);
        return mapUnitToUnitDto(unit);
    }

    private UnitDto mapUnitToUnitDto(Unit unit) {
        return new UnitDto(
                unit.getId(),
                unit.getName(),
                unit.getBlockTimes().stream().map(blockTime -> new UnitBlockDto(
                                blockTime.getId(),
                                blockTime.getStartTime(),
                                blockTime.getEndTime(),
                                blockTime.getReason(),
                                blockTime.getBlockStatus()
                        )
                ).toList()
        );
    }

}
