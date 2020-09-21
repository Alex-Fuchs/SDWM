package com.siltronic.diversity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siltronic.diversity.data_access.dao.EmployeeDAO;
import com.siltronic.diversity.data_access.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeDAO> getEmployeesByCountry(String name) {
		return employeeRepository.findByCountry(name);
	}
	
	public List<EmployeeDAO> getEmployeesByEntry(String entry) {
		return employeeRepository.findByEntry(entry);
	}
	
	public void insertEmployee(String firstName, String secondName, String birthPlace) {
		employeeRepository.insert(firstName, secondName, birthPlace);
	}
}
