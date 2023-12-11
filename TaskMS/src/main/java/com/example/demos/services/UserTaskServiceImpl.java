package com.example.demos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Task;
import com.example.demo.entites.UserTask;
import com.example.demo.repository.IUserTaskRepository;

@Service("UserTaskServiceImpl")
public class UserTaskServiceImpl implements ITaskService {

	private IUserTaskRepository repo;
	private ITaskTableService taskTableService;

	@Autowired
	public UserTaskServiceImpl(IUserTaskRepository repo, ITaskTableService taskTableService) {
		this.repo = repo;
		this.taskTableService = taskTableService;
	}

	@Override
	public void createTask(Task task) {
		repo.save((UserTask) task);
	}

	@Override
	public void setTaskToTaskTable(Long idTask, Long idTaskTable) {
		var task = repo.findById(idTask);
		task.ifPresentOrElse(t -> taskTableService.addTask(idTaskTable, t), () -> {
			throw new IllegalArgumentException(String.format("No task exist in dataBase with the id %s", idTask));
		});
	}

}
