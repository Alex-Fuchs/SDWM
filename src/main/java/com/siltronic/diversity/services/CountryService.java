package com.siltronic.diversity.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.siltronic.diversity.data_access.dao.CountryDAO;
import com.siltronic.diversity.data_access.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private EmployeeService employeeService;

	public String getCountries() {
		List<CountryDAO> countries = countryRepository.findAll();
		for (CountryDAO tmp: countries) {
			int numberOfEmployees = employeeService.getEmployeesByCountry(tmp.getName()).size();
			tmp.setValue(numberOfEmployees);
			if (numberOfEmployees > 0) {
				tmp.setColor("#1389ae");
			} else {
				tmp.setColor("#BDBDBD");
			}
		}
		return new Gson().toJson(countries.toArray());
	}
	
	public List<CountryDAO> getCountriesAsList() {
		return countryRepository.findAllSort();
	}
}
