package com.example.demo.entites;

import java.io.IOException;

import com.example.demo.Enum.Priority;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class TaskDeserializer extends StdDeserializer<Task> {

	private static final long serialVersionUID = 1L;

	public TaskDeserializer() {
	        this(null);
	    }

	    public TaskDeserializer(Class<?> vc) {
	        super(vc);
	    }

	    @Override
	    public Task deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
	    	
	    	 JsonNode node = jp.getCodec().readTree(jp);
	         String type = node.get("type").asText();

	         switch (type) {
	         case "UserTask":
                 return createUserTask(node);

             case "ServiceTask":
                 return createServiceTask(node);
	             default:
	                 throw new IllegalArgumentException("Unknown task type: " + type);
	         }
	    }

		private Task createServiceTask(JsonNode node) {
			ServiceTask task = new ServiceTask();
			task.setDescription(node.get("description").asText());
			task.setId(node.get("id").asLong());
			task.setName(node.get("name").asText());
			task.setPriority(Priority.valueOf(node.get("priority").asText()));
			task.setTaskCost(node.get("taskCost").asDouble());
			return task;
		}

		private Task createUserTask(JsonNode node) {
			UserTask task = new UserTask();
			task.setId(node.get("id").asLong());
			task.setDescription(node.get("description").asText());
			task.setName(node.get("name").asText());
			task.setPriority(Priority.valueOf(node.get("priority").asText()));
			task.setTaskCost(node.get("taskCost").asDouble());
			return task;
		}
	
}
