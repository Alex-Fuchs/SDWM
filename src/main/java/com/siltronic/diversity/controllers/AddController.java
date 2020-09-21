package com.siltronic.diversity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siltronic.diversity.services.EmployeeService;

@Controller
public class AddController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("add")
	@ResponseBody
	public String setAdd(@RequestParam String id, @RequestParam String firstName, @RequestParam String secondName, @RequestParam String birthPlace) {
		employeeService.insertEmployee(firstName, secondName, birthPlace);
		return "<script LANGUAGE='JavaScript'>\n" +
                "    window.location.href='/';\n" +
                "</script>";
	}
}
