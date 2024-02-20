package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeDTO;
import com.example.demo.response.DeleteResponse;
import com.example.demo.services.EmployeeServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("Emp/api")
public class EmployeeController {

	private EmployeeServices employeeServices;

	@PostMapping("/create")
	public ResponseEntity<EmployeeDTO> cretaeEmp(@Valid @RequestBody EmployeeDTO emp) {

		 EmployeeDTO createEmployee = this.employeeServices.createEmployee(emp);
		return new ResponseEntity<>(createEmployee, HttpStatus.CREATED);

	}

	@GetMapping("/getSingle/{id}")
	public ResponseEntity<EmployeeDTO> getSingleEmp(@PathVariable int id) {

		EmployeeDTO singleEmp = this.employeeServices.getSingleEmployee(id);
		return new ResponseEntity<>(singleEmp, HttpStatus.CREATED);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmp(@Valid @RequestBody Employee emp, @PathVariable int id) {

		Employee updateEmployee = this.employeeServices.updateEmployee(emp, id);

		return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/allEmp")
	public ResponseEntity<List<EmployeeDTO>> getAllEmp() {

		List<EmployeeDTO> allEmployee = this.employeeServices.getAllEmployee();

		return new ResponseEntity<List<EmployeeDTO>>(allEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<DeleteResponse> deleteEmp(@PathVariable int id) {

		this.employeeServices.deleteEmployee(id);

		return new ResponseEntity<>(new DeleteResponse("Deleted sucessfully", "true"), HttpStatus.OK);
	}

}
