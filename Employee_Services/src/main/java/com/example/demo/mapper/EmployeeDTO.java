package com.example.demo.mapper;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class EmployeeDTO {
	
	private int id;
	
	@NotBlank
	private String name;
	@Email
	private String email;
	@NotBlank
	@Min(value = 4)
	private String password;
	@NotBlank
	private String address;
	private String departmentCode;

}
