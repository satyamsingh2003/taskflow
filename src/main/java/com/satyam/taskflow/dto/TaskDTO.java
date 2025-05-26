package com.satyam.taskflow.dto;

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
	 private String title;
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
