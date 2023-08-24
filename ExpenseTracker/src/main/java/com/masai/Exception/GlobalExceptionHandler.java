package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> handleNotFound(NotFoundException ex, WebRequest req){
		 ErrorDetails ed = new ErrorDetails();
		 ed.setTimestamp(LocalDateTime.now());
		 ed.setMessage(ex.getMessage());
		 ed.setDescription(req.getDescription(false));
		 
		 return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SomethingWentWrongException.class)
	public ResponseEntity<ErrorDetails> handleNotFound(SomethingWentWrongException ex, WebRequest req){
		 ErrorDetails ed = new ErrorDetails();
		 ed.setTimestamp(LocalDateTime.now());
		 ed.setMessage(ex.getMessage());
		 ed.setDescription(req.getDescription(false));
		 
		 return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleNotFound(Exception ex, WebRequest req){
		 ErrorDetails ed = new ErrorDetails();
		 ed.setTimestamp(LocalDateTime.now());
		 ed.setMessage(ex.getMessage());
		 ed.setDescription(req.getDescription(false));
		 
		 return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
}
