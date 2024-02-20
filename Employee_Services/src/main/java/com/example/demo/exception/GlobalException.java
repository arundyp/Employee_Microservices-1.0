package com.example.demo.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

		String message = ex.getMessage();

		ApiResponse apiResponse = new ApiResponse(message);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> methodArgumentNotValid(MethodArgumentNotValidException ex) {

		Map<String, String> map = new HashMap();
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

		allErrors.forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();

			map.put(fieldName, message);
		});

		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);

	}

}
