package com.jsp.warehouse.exception;

@SuppressWarnings("serial")
public class IllegalOperationException extends RuntimeException {
	private String message;
	public IllegalOperationException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}

	

}
