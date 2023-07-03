package com.hostfully.controller;

import com.hostfully.dto.UnitDto;
import com.hostfully.services.UnitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unit")
@Tag(name = "Units")
public class UnitController implements UnitOpenApi {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public List<UnitDto> getUnits() {
        return this.unitService.getAllUnit();
    }
}
