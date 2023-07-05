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
import java.util.UUID;

public interface UnitOpenApi {
    @Operation(summary = "List all the Units, this will simulate the property search functionality")
    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UnitDto.class))
                    ) }),
    })
    public List<UnitDto> getUnits();

    @Operation(summary = "Return One Units, this it's to check data on this test")
    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UnitDto.class)
                    ) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID",
                    content =
                            { @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ErrorDetails.class)) }
            ),
            @ApiResponse(responseCode = "404", description = "Unit not found",
                    content =
                            { @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ErrorDetails.class)) })
    })
    public UnitDto getUnitById(UUID unitId);
}
