package com.schoolmonitor.exception;

/**
 * @author PrabhjeetS
 * @version 1.0
 */
public class GenericExceptionContainer<T> {
	public GenericExceptionContainer(T exceptionObject) {
		super();
		this.exceptionObject = exceptionObject;
	}

	private T exceptionObject;

	public T getExceptionObject() {
		return exceptionObject;
	}

	public void setExceptionObject(T exceptionObject) {
		this.exceptionObject = exceptionObject;

	}

}
