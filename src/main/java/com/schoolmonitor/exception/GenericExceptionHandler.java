package com.schoolmonitor.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;



@RestControllerAdvice
public class GenericExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GenericExceptionHandler.class);
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = { SchoolMonitorException.class })
	public ResponseEntity vehicleNotFound(SchoolMonitorException ex, WebRequest request) {
		logger.debug("GenericExceptionHandler:Application impacted at server ");
				return new ResponseEntity(HttpStatus.NOT_FOUND);
		
	}
}