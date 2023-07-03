package com.hostfully.controller;

import com.hostfully.exception.ErrorDetails;
import com.hostfully.dto.UnitDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

public interface UnitOpenApi {
    @Operation(summary = "List all the Units, this will simulate the property search functionality")
    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UnitDto.class))
                    ) }),
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
    public List<UnitDto> getUnits();
}
