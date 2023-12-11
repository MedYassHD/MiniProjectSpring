package com.example.demo.Util;

import com.example.demo.entites.UserTask;

public class UserTaskBuilder extends TaskBuilder {

	private String userName;

	public TaskBuilder withUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public UserTask build() {
		return new UserTask(this.name, this.description, this.priority, this.userName);
	}

}
