package com.example.demos.services;

import com.example.demo.entites.Task;

public interface ITaskService {
	
	void createTask(Task task);
	void setTaskToTaskTable( Long idTask , Long idTaskTable );
	
}
