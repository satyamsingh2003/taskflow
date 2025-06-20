package com.satyam.taskflow.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.satyam.taskflow.exceptions.NoTaskObjectFoundException;
import com.satyam.taskflow.exceptions.TaskNotFoundByIdException;
import com.satyam.taskflow.exceptions.UsernameAlreadyExistsException;

@RestControllerAdvice
public class GlobalLevelExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleNoTaskFoundException(NoTaskObjectFoundException ex){
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setErrorcode(HttpStatus.NOT_FOUND.value());
		es.setMessage(ex.getMessage());
		es.setError("Database is Empty");
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleTaskNotFoundById(TaskNotFoundByIdException ex){
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setErrorcode(HttpStatus.NOT_FOUND.value());
		es.setMessage(ex.getMessage());
		es.setError("No Task By this id is present");
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex){
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setError("Username has been already taken");
		es.setErrorcode(HttpStatus.IM_USED.value());
		es.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.IM_USED);
	}
}
