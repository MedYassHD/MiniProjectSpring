package com.example.demo.entites;

import com.example.demo.Enum.Priority;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("ServiceTask")
public class ServiceTask extends Task {

	private String serviceName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	
}
