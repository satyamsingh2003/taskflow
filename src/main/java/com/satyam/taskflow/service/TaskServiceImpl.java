package com.satyam.taskflow.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyam.taskflow.dto.TaskDTO;
import com.satyam.taskflow.entity.Task;
import com.satyam.taskflow.exceptions.NoTaskObjectFoundException;
import com.satyam.taskflow.exceptions.TaskNotFoundByIdException;
import com.satyam.taskflow.repository.TaskRepository;
@Service
public class TaskServiceImpl implements TaskService{
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<TaskDTO> getAllTask() {
		List<Task> tasks = taskRepository.findAll();
		if(tasks.isEmpty())
			throw new NoTaskObjectFoundException("No Tasks Object is Present");
		else {
			return tasks.stream().map(t-> new TaskDTO(t.getId(),t.getTitle(),t.getDescription(),t.isCompleted())).collect(Collectors.toList());
		}

	}

	@Override
	public Task createTask(Task t) {
		return taskRepository.save(t);
	}

	@Override
	public Task updateTask(Long id, Task t) {
		Optional<Task> optional = taskRepository.findById(id);
		if(optional.isEmpty())
			throw new TaskNotFoundByIdException("No Task By This ID : "+id);
		else 
		{
			 Task updatedTask = optional.get();
			 updatedTask.setCompleted(t.isCompleted());
			 updatedTask.setDescription(t.getDescription());
			 updatedTask.setTitle(t.getTitle());
			 taskRepository.save(updatedTask);
			 return updatedTask;
		}
	}

	@Override
	public Task deleteTask(Long id) {
		Optional<Task> optional = taskRepository.findById(id);
		if(optional.isEmpty())
			throw new TaskNotFoundByIdException("No Task By This ID : "+id);
		else 
		{
			 Task deletedTask = optional.get();
			 taskRepository.delete(deletedTask);
			 return deletedTask;
		}
	}
	
}