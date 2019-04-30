package com.schoolmonitor.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
	@ExceptionHandler(value = { SchoolMonitorException.class })
	public ResponseEntity vehicleNotFound(SchoolMonitorException ex, WebRequest request) {
		log.debug("handling SchoolMonitorException..");
		return notFound().build();
	}
}