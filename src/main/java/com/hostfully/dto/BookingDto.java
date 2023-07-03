package com.hostfully.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "The Booking DTO")
public record BookingDto(

        @Schema(description = "The booking ID, server generated")
        UUID id,

        @Schema(description = "The unit ID to book the time.")
        UUID unitId,

        @Schema(description = "The booking start date")
        LocalDateTime startTime,

        @Schema(description = "The booking end date")
        LocalDateTime endTime,

        @Schema(description = "The total number of night of the booking")
        int totalNights,

        @Schema(description = "The dates when booking were created")
        LocalDateTime createdAt,

        @Schema(description = "The dates when booking were updated")
        LocalDateTime updatedAt,

        @Schema(description = "The List of changes of the booking")
        List<BookingChangeLogDto> changeLog
) {
}