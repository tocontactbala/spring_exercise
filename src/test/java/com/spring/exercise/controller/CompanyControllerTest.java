package com.spring.exercise.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CompanyControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CompanyController companyController;

    @Mock
    private CompanyService companyService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
    }

    @Test
    public void testGetCompanyDetails() throws Exception {
        CompanyRequest request = new CompanyRequest();
        CompanyResponse expectedResponse = new CompanyResponse();

        String apiKey = "your-api-key";

        when(companyService.fetchCompanyDetails(request, apiKey)).thenReturn(expectedResponse);

        mockMvc.perform(post("/details")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}") // You can provide a JSON request body here
                        .header("x-api-key", apiKey))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.someField").value("expectedValue")); // Replace with actual JSON field checks

        // Verify that the companyService's saveCompanyDetails method was called
        verify(companyService, times(1)).saveCompanyDetails(any());
    }
}

