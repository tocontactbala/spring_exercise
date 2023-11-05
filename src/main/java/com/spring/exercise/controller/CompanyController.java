package com.spring.exercise.controller;

import org.springframework.web.bind.annotation.*;

import com.spring.company.request.CompanyRequest;
import com.spring.company.response.CompanyResponse;
import com.spring.exercise.service.CompanyService;

@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    @PostMapping("/details")
    public CompanyResponse getCompanyDetails(@RequestBody CompanyRequest request,
                                             @RequestHeader("x-api-key") String apiKey) {
        CompanyResponse response = companyService.fetchCompanyDetails(request, apiKey);

        companyService.saveCompanyDetails(response.getItems().get(0));

        return response;
    }
}
