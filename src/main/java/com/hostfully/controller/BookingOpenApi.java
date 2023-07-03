package com.hostfully.controller;

import com.hostfully.exception.ErrorDetails;
import com.hostfully.dto.BookingDto;
import com.hostfully.dto.ListBookingDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

public interface BookingOpenApi {
    @Operation(summary = "Create a unit booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "409", description = "Error on booking", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorDetails.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorDetails.class)) })

    })
    public ResponseEntity<String> createBooking(@RequestBody BookingDto booking);

    @Operation(summary = "Update a unit booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = BookingDto.class)) }),
            @ApiResponse(responseCode = "409", description = "Error on booking", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorDetails.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorDetails.class)) })

    })
    public ResponseEntity<String> updateBooking(@PathVariable("id") long id, @RequestBody BookingDto booking);

    @Operation(summary = "Delete a unit booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Deleted"),
            @ApiResponse(responseCode = "409", description = "Error on booking", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorDetails.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorDetails.class)) })

    })
    public ResponseEntity<String> deleteBooking(@PathVariable("id") long id);


    @Operation(summary = "List all booking of a Unit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = ListBookingDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied",
                    content =
                            { @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ErrorDetails.class)) }
            ),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content =
                            { @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ErrorDetails.class)) })
    })
    public ListBookingDto getBookingOfUnit(
            @PathVariable("id") UUID id,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    );
}
