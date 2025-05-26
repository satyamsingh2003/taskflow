package com.satyam.taskflow.utility;

public class ErrorStructure<T> {
	private int errorcode;
	private String message;
	private T error;
	public T getError() {
		return error;
	}
	public void setError(T error) {
		this.error = error;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
