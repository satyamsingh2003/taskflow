package com.satyam.taskflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyam.taskflow.entity.Task;
import com.satyam.taskflow.repository.TaskRepository;

@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@PostMapping
	public Task createTask(@RequestBody Task t) {
		return taskRepository.save(t);
	}
	
	@GetMapping
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}

}
