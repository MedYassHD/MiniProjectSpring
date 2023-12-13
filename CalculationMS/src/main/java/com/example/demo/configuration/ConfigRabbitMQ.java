package com.example.demo.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entites.TaskTable;

@Configuration
public class ConfigRabbitMQ {

	@Bean
	public Queue myQueue() {
		return new Queue("myQueue");
	}

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(TaskTable table) {
		rabbitTemplate.convertAndSend("myQueue", table);
	}

}
