package com.example.demos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Task;
import com.example.demo.entites.TaskTable;
import com.example.demo.repository.ITaskTableRepository;

@Service
public class TaskTableServiceImpl implements ITaskTableService {

	private ITaskTableRepository repo;

	@Autowired
	public TaskTableServiceImpl(ITaskTableRepository repo) {
		this.repo = repo;
	}

	@Override
	public TaskTable createTaskTable(TaskTable taskTable) {
		repo.save(taskTable);
		return taskTable;
	}

	@Override
	public void addTask(long taskTableId, Task task) {
		var optionalTaskTable = repo.findById(taskTableId);
		optionalTaskTable.ifPresentOrElse(t -> t.getTasks().add(task), () -> {
			throw new IllegalArgumentException(String.format("No TaskTable in dataBase with the id %s", taskTableId));
		});
	}

	@Override
	public TaskTable getTaskTable() {
		var taskTable = repo.findAll().iterator().next();
		if (taskTable != null) {
			return taskTable;
		}
		throw new IllegalArgumentException("No TaskTable in dataBase ");
	}

}
