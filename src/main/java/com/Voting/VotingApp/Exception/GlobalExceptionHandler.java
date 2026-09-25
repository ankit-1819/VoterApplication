package com.Voting.VotingApp.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Voting.VotingApp.Dto.ErrorStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorStructure> handleIdNotFoundException(IdNotFoundException ex){
		
		ErrorStructure error = new ErrorStructure();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorStructure>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(VoterAgeException.class)
	public ResponseEntity<ErrorStructure> handleVoterAgeException(VoterAgeException ex){
		
		ErrorStructure error = new ErrorStructure();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorStructure>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorStructure> handleGenericException(Exception ex){
		
		ErrorStructure error = new ErrorStructure();
		
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("Something Went Wrong!!!");
		
		return new ResponseEntity<ErrorStructure>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorStructure> handleValidationException(MethodArgumentNotValidException ex){
		
		ErrorStructure error = new ErrorStructure();
		
		Map<String, String> validation = new HashMap<String, String>();
		
	
		for (FieldError errors : ex.getBindingResult().getFieldErrors()) {
		    validation.put(errors.getField(), errors.getDefaultMessage());
		}
		
		
		error.setMessage("Validation failed!!!");
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError(validation);
		
		return new ResponseEntity<ErrorStructure>(error,HttpStatus.BAD_REQUEST);
	}
}
