package com.hostfully.dto;

import java.util.List;
import java.util.UUID;

public record UnitDto (
        UUID id,
        String name,
        List<UnitBlockDto> blockDates
) {
}
