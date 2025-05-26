package com.satyam.taskflow.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyam.taskflow.dto.TaskDTO;
import com.satyam.taskflow.entity.Task;
import com.satyam.taskflow.service.TaskService;
import com.satyam.taskflow.utility.ResponseStructure;

@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Task>> create(@RequestBody Task t) {
		ResponseStructure<Task> rs = new ResponseStructure<Task>();
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("Task Objects Created Successfully");
		rs.setData(taskService.createTask(t));
		return new ResponseEntity<ResponseStructure<Task>>(rs,HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<TaskDTO>>> getAll(){
		ResponseStructure<List<TaskDTO>> rs = new ResponseStructure<List<TaskDTO>>();
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("Task Objects Found Successfully");
		rs.setData(taskService.getAllTask());
		return new ResponseEntity<ResponseStructure<List<TaskDTO>>>(rs,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Task>> update(@PathVariable Long id,@RequestBody Task t){
		ResponseStructure<Task> rs = new ResponseStructure<Task>();
		rs.setStatuscode(HttpStatus.ACCEPTED.value());
		rs.setMessage("Task Object Updated Successfully");
		rs.setData(taskService.updateTask(id,t));
		return new ResponseEntity<ResponseStructure<Task>>(rs,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Task>> delete(@PathVariable Long id){
		ResponseStructure<Task> rs  = new ResponseStructure<Task>();
		rs.setStatuscode(HttpStatus.ACCEPTED.value());
		rs.setMessage("Task Object is Successfully Deleted");
		rs.setData(taskService.deleteTask(id));
		return new ResponseEntity<ResponseStructure<Task>>(rs,HttpStatus.ACCEPTED);
	}
}
 