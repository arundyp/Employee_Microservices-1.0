package com.department.arun.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.department.arun.payload.ApiResponse;

@ControllerAdvice
public class GlobalException  {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> notfound(ResourceNotFoundException ex){
		
		String message=ex.getMessage();
		ApiResponse api= new ApiResponse(message);
		
		
		return new ResponseEntity<ApiResponse>(api,HttpStatus.NOT_FOUND);
	}

}
