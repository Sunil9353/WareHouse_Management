package com.jsp.warehouse.exception;

@SuppressWarnings("serial")
public class WarehouseNotFoundByIdException extends RuntimeException {
	private String message ;
	
	public WarehouseNotFoundByIdException(String message ) {
		this.message=message ;
		
	}
	
	public String getMessage() {
		return message;
	}
	
	
	
	

}
