package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IcalculationService;

@RestController
@RequestMapping("/api/Caclule")
public class CalculationController {
	
	private final IcalculationService service;
	
	public CalculationController(IcalculationService service) {
		this.service = service;
	}
	
	@GetMapping("/calcul")
	public void doCalcule() {
		service.retriveTasks();
	}
}
