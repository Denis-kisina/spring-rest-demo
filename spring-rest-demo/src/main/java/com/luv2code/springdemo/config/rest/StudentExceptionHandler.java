package com.luv2code.springdemo.config.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

//	add exception handler 

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//		create a student error response message
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
