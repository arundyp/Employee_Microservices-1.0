package com.example.demo.exception;

import lombok.Data;

@Data
public class EmailAlreadyExistsException extends RuntimeException {

//	String message;
//	EmailAlreadyExistsException() {
//		super();
//
//	}
	
	
	public EmailAlreadyExistsException(String message) {
		
		super(message);
		
		

	}

}
