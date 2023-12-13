package com.example.demo.entites;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("UserTask")
public class UserTask extends Task {
	
	private static final long serialVersionUID = -2360457110040564299L;


	private String userName;
	
	
}
