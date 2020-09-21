package com.siltronic.diversity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siltronic.diversity.services.EmployeeService;

@Controller
public class EmployeesController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("employeesByCountry")
	public String getCountry(@RequestParam String country, Model model) {
		setModel(country, model);
		return "employees";
	}
	
	@GetMapping("employees")
	public String getEmployees(@RequestParam String entry, Model model) {
		setModelForEmployees(entry, model);
		return "employees";
	}
	
	private void setModel(String country, Model model) {
		model.addAttribute("employees", employeeService.getEmployeesByCountry(country));
	}
	
	private void setModelForEmployees(String entry, Model model) {
		model.addAttribute("employees", employeeService.getEmployeesByEntry(entry));
	}
}
