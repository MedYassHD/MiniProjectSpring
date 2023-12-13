package com.example.demo.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.configuration.ConfigRabbitMQ;
import com.example.demo.entites.TaskTable;

@Service
public class CalculationService implements IcalculationService {
	
	private final String apiUrl = "http://localhost:8080/api/taskTable/getById"; 
	
	@Autowired
    private ConfigRabbitMQ rabbitMQConfig;
	
	@Override
	public TaskTable retriveTasks() {
		
		WebClient webClient = WebClient.create(apiUrl);

		TaskTable response = webClient
					.get()
					.retrieve()
					.toEntity(TaskTable.class)
					.block()
					.getBody()
					;
		
		return response;
	}
	
	public void doCalculation(TaskTable table) {
		table.getTasks().stream().forEach(t -> {
			t.setTaskCost( new Random().nextDouble() );
		});
		
		rabbitMQConfig.sendMessage(table);
	}
	

}
