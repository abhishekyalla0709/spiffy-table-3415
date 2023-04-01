package com.thrillcity.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.thrillcity.model.Admin;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<MyErrorDetails> adminException(AdminException adminException, WebRequest wr){
		MyErrorDetails myerrordetails = new MyErrorDetails();
		myerrordetails.setTimeStamp(LocalDateTime.now());
		myerrordetails.setMsg(adminException.getMessage());
		myerrordetails.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myerrordetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyErrorDetails> customerException(CustomerException customerException, WebRequest wr){
		MyErrorDetails myerrordetails = new MyErrorDetails();
		myerrordetails.setTimeStamp(LocalDateTime.now());
		myerrordetails.setMsg(customerException.getMessage());
		myerrordetails.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myerrordetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyErrorDetails> activityException(ActivityException activityException, WebRequest wr){
		MyErrorDetails myerrordetails = new MyErrorDetails();
		myerrordetails.setTimeStamp(LocalDateTime.now());
		myerrordetails.setMsg(activityException.getMessage());
		myerrordetails.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myerrordetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyErrorDetails> ticketException(TicketException ticketException, WebRequest wr){
		MyErrorDetails myerrordetails = new MyErrorDetails();
		myerrordetails.setTimeStamp(LocalDateTime.now());
		myerrordetails.setMsg(ticketException.getMessage());
		myerrordetails.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myerrordetails, HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
