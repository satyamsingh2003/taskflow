package com.satyam.taskflow.exceptions;

public class TaskNotFoundByIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3678710685637147880L;

	private String message;

	public TaskNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
