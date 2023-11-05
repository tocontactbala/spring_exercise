package com.spring.company.api.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class CompanyApiClient {
    private static final String BASE_URL = "https://exercise.trunarrative.cloud/TruProxyAPI/rest/Companies/v1";

    private final HttpClient httpClient;
    private final String apiKey;

    public CompanyApiClient(String apiKey) {
        this.apiKey = apiKey; //api key
        this.httpClient = HttpClients.createDefault();
    }

    public String searchCompanies(String searchTerm) throws Exception {
        String searchUrl = BASE_URL + "/Search?Query=" + searchTerm;
        HttpGet request = new HttpGet(searchUrl);
        request.addHeader("x-api-key", apiKey);

        HttpResponse response = httpClient.execute(request);
        return null;
    }

    public String getCompanyOfficers(String companyNumber) throws Exception {
        String officersUrl = BASE_URL + "/Officers?CompanyNumber=" + companyNumber;
        HttpGet request = new HttpGet(officersUrl);
        request.addHeader("x-api-key", apiKey);

        HttpResponse response = httpClient.execute(request);
        return null;
    }
}
