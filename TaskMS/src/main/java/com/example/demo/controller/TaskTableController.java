package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.TaskTable;
import com.example.demos.services.ITaskTableService;

@RestController
@RequestMapping("/api/taskTable")
public class TaskTableController {

	private final ITaskTableService service;

	@Autowired
	public TaskTableController(ITaskTableService service) {
		this.service = service;
	}

	@GetMapping("/get")
	public TaskTable getTaskTable() {
		return service.getTaskTable();
	}

	@PostMapping("/create")
	public TaskTable createTaskTable(@RequestBody TaskTable taskTable) {
		return service.createTaskTable(taskTable);
	}

}
