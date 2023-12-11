package com.example.demo.Util;

import com.example.demo.Enum.Priority;
import com.example.demo.entites.Task;

public abstract class TaskBuilder {

	protected String name;
	protected String description;
	protected Priority priority;


	public TaskBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public TaskBuilder withDescription(String description) {
		this.description = description;
		return this;
	}
	
	public TaskBuilder withPriority(Priority priority) {
		this.priority = priority;
		return this;
	}
	
	public abstract Task build();

}
