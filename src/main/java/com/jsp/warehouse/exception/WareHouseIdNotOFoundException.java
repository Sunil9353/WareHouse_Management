package com.jsp.warehouse.exception;

@SuppressWarnings("serial")
public class WareHouseIdNotOFoundException extends RuntimeException {

	private String meassage;

	public WareHouseIdNotOFoundException(String meassage) {
		this.meassage=meassage;
	}
	
	public String getMessage() {
		return meassage;
	}




}
