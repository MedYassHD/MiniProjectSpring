package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Task;
import com.example.demos.services.ITaskService;

@RestController
@RequestMapping("/api/taskTable")
public class TaskController {

	private final ITaskService serviceTaskService;
	private final ITaskService userTaskService;

	@Autowired
	public TaskController(@Qualifier("ServiceTaskServiceImpl") ITaskService serviceTaskService,
			@Qualifier("UserTaskServiceImpl") ITaskService userTaskService) {

		this.serviceTaskService = serviceTaskService;
		this.userTaskService = userTaskService;

	}

	@PostMapping("/createUserTask")
	public void createUserTask(@RequestBody Task userTask) {
		userTaskService.createTask(userTask);
	}

	@PostMapping("/createServiceTask")
	public void createServiceTask(@RequestBody Task serviceTask) {
		serviceTaskService.createTask(serviceTask);
	}

	@PostMapping("/setUserTaskToTaskTable")
	public void setUserTaskToTaskTable(@PathVariable Long taskTableId, @PathVariable Long taskId) {
		userTaskService.setTaskToTaskTable(taskId, taskTableId);
	}

	@PostMapping("/setUServiceTaskToTaskTable")
	public void setTaskToTaskTable(@PathVariable Long taskTableId, @PathVariable Long taskId) {
		serviceTaskService.setTaskToTaskTable(taskId, taskTableId);
	}

}
