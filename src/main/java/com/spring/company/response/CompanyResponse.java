package com.spring.company.response;

import java.util.List;

import com.spring.exercise.model.Company;

public class CompanyResponse {
    private int total_results;
    private List<Company> items;
    
	public int getTotal_results() {
		return total_results;
	}
	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}
	public List<Company> getItems() {
		return items;
	}
	public void setItems(List<Company> items) {
		this.items = items;
	}
    
}
