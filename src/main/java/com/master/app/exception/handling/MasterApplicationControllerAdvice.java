package com.master.app.exception.handling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.master.app.model.ApplicationErrorMessage;

@RestControllerAdvice
public class MasterApplicationControllerAdvice {
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ApplicationErrorMessage>  internalServerError(HttpServletRequest req, Throwable ex){
		ApplicationErrorMessage errorMessage = new ApplicationErrorMessage();
		StringBuffer requestURL = req.getRequestURL();
		errorMessage.setErrorCode("E0007");
		errorMessage.setErrorMessage("Your trying the to process wrong data or data not available in database  :"+requestURL);
		return new ResponseEntity<ApplicationErrorMessage>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
