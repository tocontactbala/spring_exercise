package com.spring.exercise.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFetchCompanyDetails() {
        CompanyRequest request = new CompanyRequest();
        String apiKey = "your-api-key";
        when(companyRepository.findByApiKey(apiKey)).thenReturn(new Company());
        CompanyResponse response = companyService.fetchCompanyDetails(request, apiKey);
        assertNotNull(response);
    }

    @Test
    public void testSaveCompanyDetails() {
        Company company = new Company();
        companyService.saveCompanyDetails(company);
        verify(companyRepository, times(1)).save(company);
    }
}

