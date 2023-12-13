package com.example.demo.entites;

import com.example.demo.Enum.Priority;

import jakarta.persistence.Entity;

@Entity
public class UserTask extends Task {
	
	private static final long serialVersionUID = -2360457110040564299L;

	private String userName;
	
	public UserTask() {};

	
	public UserTask (String name, String description, Priority priority, String userName) {
		super();
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.userName = userName;
		this.type = getClass().getSimpleName();
	}
	
}
