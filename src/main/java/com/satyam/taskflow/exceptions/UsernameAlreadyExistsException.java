package com.satyam.taskflow.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
		
	 public UsernameAlreadyExistsException(String message) {
		this.message = message;
	}

	 public String getMessage() {
		return message;
	 }

	 public void setMessage(String message) {
		this.message = message;
	 }

	 
}
