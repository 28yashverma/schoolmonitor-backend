package com.schoolmonitor.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
public class SchoolMonitorException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(SchoolMonitorException.class);

	public SchoolMonitorException(String message) {
		logger.debug("GenericExceptionHandler:Application impacted at server: " + message);

	}

}
