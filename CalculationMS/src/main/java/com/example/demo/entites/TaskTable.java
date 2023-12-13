package com.example.demo.entites;

import java.io.Serializable;
import java.util.List;

public class TaskTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private Long id;

	private String name;

	private List<Task> tasks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
