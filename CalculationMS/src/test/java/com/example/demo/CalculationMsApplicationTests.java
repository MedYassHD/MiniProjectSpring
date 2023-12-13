package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.CalculationService;
import com.example.demo.service.IcalculationService;

@SpringBootTest
class CalculationMsApplicationTests {
	
	@Autowired
	CalculationService service;

	@Test
	void contextLoads() {
		
		var responce = service.retriveTasks();
		
		service.doCalculation(responce);
		
		responce.getTasks().forEach(t -> {
			System.out.println(t.getName());
		});
		
	}

}
