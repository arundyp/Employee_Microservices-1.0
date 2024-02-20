package com.example.demo.exception;

public class RespourceNotFoundException extends RuntimeException {

//	private String resourceName;
//	private String filedName;
//	private int fieldValue;

	public RespourceNotFoundException(String message) {
		super(message);
	}

	
//	public RespourceNotFoundException(String resourceName, String filedName, int fieldValue) {
//		super();
//		this.resourceName = resourceName;
//		this.filedName = filedName;
//		this.fieldValue = fieldValue;
//	}

}
