package com.hostfully.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ListBookingResponseDto(
        @ArraySchema(schema = @Schema(implementation = BookingDto.class))
        List<BookingDto> bookings,
        @Schema(description = "The page number")
        int pageNo,

        @Schema(description = "The item size per page")
        int pageSize,

        @Schema(description = "The total of items")
        long totalElements,

        @Schema(description = "The total number of pages")
        int totalPages
) {
}