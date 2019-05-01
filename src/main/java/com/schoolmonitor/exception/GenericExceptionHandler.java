package com.schoolmonitor.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
//@Slf4j
public class GenericExceptionHandler {
	@ExceptionHandler(value = { SchoolMonitorException.class })
	public ResponseEntity vehicleNotFound(SchoolMonitorException ex, WebRequest request) {
		//log.debug("handling SchoolMonitorException..");//lambock log not working as of now
		//return notFound().build();
		return null;
	}
}