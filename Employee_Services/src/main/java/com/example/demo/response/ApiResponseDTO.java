package com.example.demo.response;

import com.example.demo.mapper.DepartmentDTO;
import com.example.demo.mapper.EmployeeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponseDTO {
	
	private EmployeeDTO employeeDto;
	private DepartmentDTO departmentDTO;


}
