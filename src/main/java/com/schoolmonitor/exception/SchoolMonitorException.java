package com.schoolmonitor.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class SchoolMonitorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(SchoolMonitorException.class);

	public SchoolMonitorException(String meassage) {
		logger.debug("GenericExceptionHandler:Application impacted at server " + meassage);

	}

}
