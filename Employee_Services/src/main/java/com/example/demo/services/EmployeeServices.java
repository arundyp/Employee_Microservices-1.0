package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeDTO;

public interface EmployeeServices {
	
	EmployeeDTO createEmployee(EmployeeDTO emp);
	
	EmployeeDTO getSingleEmployee(int id);
	
	List<EmployeeDTO> getAllEmployee();
	
	Employee updateEmployee(Employee emp, int id);
	
	void deleteEmployee(int id);
	
	//Employee findUniqueEmil(String email);

}
