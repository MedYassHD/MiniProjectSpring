package com.example.demo.entites;

import java.io.Serializable;

import com.example.demo.Enum.Priority;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = TaskDeserializer.class)
public abstract class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	protected String name;

	protected String description;

	protected String type;

	protected Priority priority;

    @JsonIgnoreProperties("task")
	private TaskTable taskTable;

	protected Double taskCost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public TaskTable getTaskTable() {
		return taskTable;
	}

	public void setTaskTable(TaskTable taskTable) {
		this.taskTable = taskTable;
	}

	public Double getTaskCost() {
		return taskCost;
	}

	public void setTaskCost(Double taskCost) {
		this.taskCost = taskCost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
