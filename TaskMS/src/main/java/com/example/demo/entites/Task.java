package com.example.demo.entites;

import java.io.Serializable;

import com.example.demo.Enum.Priority;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	protected String name;

	protected String description;

	@Enumerated(EnumType.STRING)
	protected Priority priority;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne
	@JsonIgnore
	private TaskTable taskTable;
	
	protected Double taskCost;
	
	protected String type;

	public Double getTaskCost() {
		return taskCost;
	}

	public void setTaskCost(Double taskCost) {
		this.taskCost = taskCost;
	}
}
