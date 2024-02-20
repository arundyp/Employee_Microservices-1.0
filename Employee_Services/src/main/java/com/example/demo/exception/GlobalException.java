package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.response.ApiResponse;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(RespourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFound(RespourceNotFoundException ex) {

		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ApiResponse> emailAlreadyExist(EmailAlreadyExistsException ex) {

		String message=ex.getMessage();
		
		ApiResponse apiResponse = new ApiResponse(message);
	
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);

		

	}

}
