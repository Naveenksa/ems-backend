package com.naveen.emsbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naveen.emsbackend.dto.EmployeeDTO;
import com.naveen.emsbackend.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setup() {
        mockMvc = standaloneSetup(employeeController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
     void testCreateEmployee() throws Exception {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .firstName("Naveen")
                .lastName("Kumar")
                .build();
        EmployeeDTO savedEmployeeDTO = employeeDTO.toBuilder()
                .id(1L)
                .build();

        when(employeeService.createEmployee(any(EmployeeDTO.class))).thenReturn(savedEmployeeDTO);

        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(savedEmployeeDTO)));

        verify(employeeService).createEmployee(any(EmployeeDTO.class));
    }
}