package com.satyam.taskflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskDTO {
	
	
	
	public TaskDTO(Long id, String title, String description, boolean completed) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = completed;
	}
	private Long id;
	 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 100, message = "Title must be less than 100 characters")
	 private String title;
    
    @Size(max = 500, message = "Description must be less than 500 characters")
	    private String description;
	    private boolean completed;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isCompleted() {
			return completed;
		}
		public void setCompleted(boolean completed) {
			this.completed = completed;
		}

}
