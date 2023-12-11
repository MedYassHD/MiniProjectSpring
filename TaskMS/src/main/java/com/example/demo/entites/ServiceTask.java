package com.example.demo.entites;

import com.example.demo.Enum.Priority;

import jakarta.persistence.Entity;

@Entity
public class ServiceTask extends Task {

	private String serviceName;

	public ServiceTask (String name, String description, Priority priority, String serviceName) {
		super();
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.serviceName = serviceName;
	}

	
}
