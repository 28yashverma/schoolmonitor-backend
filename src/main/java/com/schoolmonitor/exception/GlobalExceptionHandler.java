package com.schoolmonitor.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.schoolmonitor.model.ApiError;

/**
 * @author PrabhjeetS
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	ApiError apiError;

	@ExceptionHandler({ BadCredentialsException.class, UsernameNotFoundException.class, SchoolMonitorException.class })
	public final ResponseEntity<?> handleException(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.NOT_FOUND;
		GenericExceptionContainer<?> genericExceptionContainer = new GenericExceptionContainer<>(ex);
		return handleException(headers, genericExceptionContainer, status, request);

	}

	private ResponseEntity<ApiError> handleException(HttpHeaders headers, GenericExceptionContainer<?> exception,
			HttpStatus status, WebRequest request) {
		apiError.setHttpStatusValue(status.value());
		apiError.setHttpStatusCode(status.name());
		apiError.setHeaderMappings(headers.entrySet());
		apiError.setRequestDescription(request.getDescription(false));
		apiError.setRequestDescription(((Throwable) exception.getExceptionObject()).getMessage());
		return new ResponseEntity<>(apiError, headers, status);
	}

}