package com.hostfully.controller;

import com.hostfully.controller.UnitController;
import com.hostfully.dto.UnitDto;
import com.hostfully.services.UnitService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@WebMvcTest(UnitController.class)
@SpringJUnitConfig
public class UnitControllerTest {

    @MockBean
    private UnitService unitService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUnits() throws Exception {
        List<UnitDto> units = Arrays.asList(new UnitDto(UUID.randomUUID(), "Unit 1", null), new UnitDto(UUID.randomUUID(), "Unit 2", null));
        Mockito.when(unitService.getAllUnit()).thenReturn(units);

        mockMvc.perform(MockMvcRequestBuilders.get("/unit")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(units.get(0).id().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(units.get(0).name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(units.get(1).id().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value(units.get(1).name()));

        Mockito.verify(unitService, Mockito.times(1)).getAllUnit();
    }

    @Test
    public void testGetUnitById() throws Exception {
        UUID unitId = UUID.randomUUID();
        UnitDto unit = new UnitDto(unitId, "Unit 1", null);
        Mockito.when(unitService.getUnitById(unitId)).thenReturn(unit);

        mockMvc.perform(MockMvcRequestBuilders.get("/unit/{unitId}", unitId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(unit.id().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(unit.name()));

        Mockito.verify(unitService, Mockito.times(1)).getUnitById(unitId);
    }
}