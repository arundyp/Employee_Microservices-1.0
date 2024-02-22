package com.department.arun.mapper;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class DepartmentDTO {
	
	private int id;
	@NotBlank
	private String dept_name;
	@NotBlank
	private String description;
	@NotBlank
	private String departmentCode;

}
