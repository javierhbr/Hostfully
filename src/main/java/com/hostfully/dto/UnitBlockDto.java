package com.hostfully.dto;

import com.hostfully.model.BlockStatus;

import java.time.LocalDate;
import java.util.UUID;

public record UnitBlockDto(
        UUID id,
        LocalDate startTime,
        LocalDate endTime,
        String reason,
        BlockStatus blockStatus
) {
}
