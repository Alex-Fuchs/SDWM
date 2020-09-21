package com.siltronic.diversity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.siltronic.diversity.services.CountryService;

@Controller
public class WorldController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping()
	public String getWorld(Model model) {
		setModel(model);
		return "world";
	}
	
	private void setModel(Model model) {
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("countriesAsList", countryService.getCountriesAsList());
	}
}
