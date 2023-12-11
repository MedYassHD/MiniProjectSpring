package com.example.demo.entites;

import com.example.demo.Enum.Priority;

import jakarta.persistence.Entity;

@Entity
public class UserTask extends Task {

	private String userName;
	
	public UserTask (String name, String description, Priority priority, String userName) {
		super();
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.userName = userName;
	}
	
}
