package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeDTO;
import com.example.demo.response.ApiResponseDTO;

public interface EmployeeServices {
	
	EmployeeDTO createEmployee(EmployeeDTO emp);
	
	ApiResponseDTO getSingleEmployee(int id);
	
	List<EmployeeDTO> getAllEmployee();
	
	Employee updateEmployee(Employee emp, int id);
	
	void deleteEmployee(int id);
	
	//Employee findUniqueEmil(String email);

}
