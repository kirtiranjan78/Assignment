package com.mindfire.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
/***
 * EmployeeExceptionHandler class for handling exceptions in all the controller classes.
 */
@RestControllerAdvice
public class PerformanceExceptionHandler {
	
	/**
     * Handles validation exceptions when arguments are not valid (e.g., @Valid validation errors)
     */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleInvalidRating(ConstraintViolationException ex) {
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	        if (violation.getPropertyPath().toString().equals("rating")) {
	            return new ResponseEntity<String>(violation.getMessage(),HttpStatus.BAD_REQUEST); 
	        }
	    }
	    return new ResponseEntity<String>("Invalid Rating",HttpStatus.BAD_REQUEST); 
	}
	
}
