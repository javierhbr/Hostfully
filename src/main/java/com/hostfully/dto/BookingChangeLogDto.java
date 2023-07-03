package com.hostfully.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "A BookingChangeLogDto object")
public record BookingChangeLogDto(
        @Schema(description = "The BookingChangeLog ID, server generated")
        UUID id,
        @Schema(description = "The booking ID of the log")
        UUID booking_id,
        @Schema(description = "The booking start date")
        LocalDateTime startTime,

        @Schema(description = "The booking end date")
        LocalDateTime endTime,

        @Schema(description = "The total number of night of the booking")
        int totalNights,

        @Schema(description = "The dates when booking were created")
        LocalDateTime createdAt
) {
}
