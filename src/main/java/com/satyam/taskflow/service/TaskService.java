package com.satyam.taskflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.satyam.taskflow.dto.TaskDTO;
import com.satyam.taskflow.entity.Task;

@Service
public interface TaskService {
	Task createTask(Task t);
	List<TaskDTO> getAllTask();
	Task updateTask(Long id, Task t);
	Task deleteTask(Long id);

}
