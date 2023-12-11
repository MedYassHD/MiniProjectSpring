package com.example.demo.entites;

import com.example.demo.Enum.Priority;

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
public abstract class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	protected String name;

	protected String description;

	@Enumerated(EnumType.STRING)
	protected Priority priority;
	
	@ManyToOne
	private TaskTable taskTable;
	
	protected Double taskCost;
}
