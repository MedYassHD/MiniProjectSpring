package com.example.demo.rabbitMQ;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper.TypePrecedence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entites.ServiceTask;
import com.example.demo.entites.TaskTable;
import com.example.demo.entites.UserTask;
import com.example.demos.services.ITaskService;
import com.example.demos.services.ITaskTableService;

@Configuration
public class RabbitMQConsumer {

	private final ITaskTableService taskTableService;
	private final ITaskService userTaskService;
	private final ITaskService serviceTaskService;

	public RabbitMQConsumer(ITaskTableService iTaskTableService,
			@Qualifier("UserTaskServiceImpl") ITaskService userTaskService,
			@Qualifier("ServiceTaskServiceImpl") ITaskService serviceTaskService) {
		this.taskTableService = iTaskTableService;
		this.userTaskService = userTaskService;
		this.serviceTaskService = serviceTaskService;
	}

	@RabbitListener(queues = "myQueue")
	public void receiveRawMessage(Message message) {
		byte[] payload = message.getBody();

		TaskTable table;

		try (ByteArrayInputStream bis = new ByteArrayInputStream(payload);
				ObjectInputStream ois = new ObjectInputStream(bis)) {

			table = (TaskTable) ois.readObject();
			table.getTasks().forEach(t -> {
				if (UserTask.class.isInstance(t)) {
					userTaskService.createTask(t);
				}
				if (ServiceTask.class.isInstance(t)) {
					serviceTaskService.createTask(t);
				}
			});
			taskTableService.createTaskTable(table);

		} catch (IOException | ClassNotFoundException e) {
			throw new IllegalArgumentException("An exception occured :" + e.getMessage());
		}

	}

	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
		converter.setJavaTypeMapper(new DefaultJackson2JavaTypeMapper());
		((DefaultJackson2JavaTypeMapper) converter.getJavaTypeMapper()).setTypePrecedence(TypePrecedence.TYPE_ID);
		((DefaultJackson2JavaTypeMapper) converter.getJavaTypeMapper()).setTrustedPackages("java.util");

		return converter;
	}

}
