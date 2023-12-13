package com.example.demos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entites.Task;
import com.example.demo.entites.TaskTable;
import com.example.demo.repository.ITaskTableRepository;

@Service
public class TaskTableServiceImpl implements ITaskTableService {

	private ITaskTableRepository repo;

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
		var taskTable = getTaskTableById(taskTableId);
		if (taskTable.getTasks() != null) {
			taskTable.getTasks().add(task);
		} else {
			taskTable.setTasks(List.of(task));
		}
		repo.save(taskTable);
	}

	@Override
	public TaskTable getTaskTableById(Long taskTableId) {
		var optionalTaskTable = repo.findById(taskTableId);
		if ( optionalTaskTable.isPresent() ) {
			return optionalTaskTable.get();
		}
		throw new IllegalArgumentException(String.format("No TaskTable in dataBase with the id %s", taskTableId));
	}

	@Override
	public Iterable<TaskTable> getAll() {
		return repo.findAll();
	}
	
	

}
