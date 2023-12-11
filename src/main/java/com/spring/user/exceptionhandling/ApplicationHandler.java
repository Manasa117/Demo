package com.spring.user.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.user.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationHandler {
	
	
	@ExceptionHandler(UserNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure<String>> UserNotFoundById(UserNotFoundByIdException cnf)
	{     ErrorStructure<String> es = new ErrorStructure<String>();
	               es.setStatusCode(HttpStatus.NOT_FOUND.value());
	               es.setMessage(cnf.getMess()); // message whate we threw in service 
	               es.setErrordata(" USER WITH GIVEN ID NOT PRESENT ");
	               
	               return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);



	}
	
	@ExceptionHandler(UserNotFoundByNameException.class)
	public ResponseEntity<ErrorStructure<String>> UserNotFoundByName(UserNotFoundByNameException cnf)
	{     ErrorStructure<String> es = new ErrorStructure<String>();
	               es.setStatusCode(HttpStatus.NOT_FOUND.value());
	               es.setMessage(cnf.getMess()); // message whate we threw in service 
	               es.setErrordata(" USER WITH GIVEN NAME NOT PRESENT ");
	               
	               return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);



	}
	
	@ExceptionHandler(UserNotFoundByMailException.class)
	public ResponseEntity<ErrorStructure<String>> UserNotFoundByMail(UserNotFoundByMailException cnf)
	{     ErrorStructure<String> es = new ErrorStructure<String>();
	               es.setStatusCode(HttpStatus.NOT_FOUND.value());
	               es.setMessage(cnf.getMess()); // message whate we threw in service 
	               es.setErrordata(" USER WITH GIVEN MAIL NOT PRESENT ");
	               
	               return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);



	}
	
	

}
