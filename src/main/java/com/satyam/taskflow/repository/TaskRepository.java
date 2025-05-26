package com.satyam.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyam.taskflow.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
