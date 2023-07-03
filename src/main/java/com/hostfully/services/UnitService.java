package com.hostfully.services;

import com.hostfully.dto.UnitDto;
import com.hostfully.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    private UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<UnitDto> getAllUnit(){
        return this.unitRepository.findByUnits();
    }

}
