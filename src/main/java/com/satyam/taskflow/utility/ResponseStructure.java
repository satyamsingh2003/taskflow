package com.satyam.taskflow.utility;



public class ResponseStructure<T> {
	private int statuscode;
	private String message;
	private T Data;
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return Data;
	}
	public void setData(T data) {
		Data=data;
	}
	
	
	

}
