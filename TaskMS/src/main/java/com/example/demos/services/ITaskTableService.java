package com.example.demos.services;

import com.example.demo.entites.Task;
import com.example.demo.entites.TaskTable;

public interface ITaskTableService {
	
	void addTask(long taskTableId , Task task);
	TaskTable createTaskTable(TaskTable taskTable);
	TaskTable getTaskTable();

}
