package com.hostfully.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Create The Booking DTO")
public record CreateBookingDto(

        @Schema(description = "The unit ID to book the time.")
        UUID unitId,

        @Schema(description = "The id of Guest user.")
        UUID guestId,

        @Schema(description = "The booking start date")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate startTime,

        @Schema(description = "The booking end date")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate endTime
) {
}