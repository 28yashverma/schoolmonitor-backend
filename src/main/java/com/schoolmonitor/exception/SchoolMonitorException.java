package com.schoolmonitor.exception;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
public class SchoolMonitorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	Throwable ex;

	public SchoolMonitorException(Throwable ex) {
		super();
		this.ex = ex;
	}

	public Throwable getEx() {
		return ex;
	}

	public void setEx(Throwable ex) {
		this.ex = ex;
	}
}
