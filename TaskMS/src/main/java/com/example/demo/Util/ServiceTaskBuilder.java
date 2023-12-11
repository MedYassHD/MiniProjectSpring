package com.example.demo.Util;

import com.example.demo.entites.ServiceTask;

public class ServiceTaskBuilder extends TaskBuilder {

	private String serviceName;

	public TaskBuilder withServiceName(String serviceName) {
		this.serviceName = serviceName;
		return this;
	}

	public ServiceTask build() {
		return new ServiceTask(this.name, this.description, this.priority, this.serviceName);
	}

}
