package com.satyam.taskflow.exceptions;

public class NoTaskObjectFoundException extends RuntimeException {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private String message;

 public NoTaskObjectFoundException(String message) {
	this.message = message;
 }

 public String getMessage() {
	return message;
 }

 public void setMessage(String message) {
	this.message = message;
 }

 
}
