package com.department.arun.controller;

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

import com.department.arun.entity.Department;
import com.department.arun.mapper.DepartmentDTO;
import com.department.arun.payload.Message;
import com.department.arun.services.DepartmentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/dept/api")
public class DepartmentController {

	private DepartmentService departmentService;
	private List<DepartmentDTO> findDepartmentCode;

	@PostMapping("/create")
	public ResponseEntity<DepartmentDTO> createDeptarmnet(@Valid @RequestBody DepartmentDTO departmentDTO) {

		DepartmentDTO createDept = this.departmentService.createDept(departmentDTO);

		return new ResponseEntity<DepartmentDTO>(createDept, HttpStatus.CREATED);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<DepartmentDTO> getSinleDept(@PathVariable int id) {
		DepartmentDTO departmentDTO = this.departmentService.getDept(id);

		return new ResponseEntity<DepartmentDTO>(departmentDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<DepartmentDTO> updateDept(@RequestBody DepartmentDTO dept, @PathVariable int id) {

		DepartmentDTO updateDept = this.departmentService.updateDept(dept, id);

		return new ResponseEntity<DepartmentDTO>(updateDept, HttpStatus.ACCEPTED);

	}

	@GetMapping("/all")
	public ResponseEntity<List<DepartmentDTO>> getAllDept() {

		List<DepartmentDTO> allDept = this.departmentService.getAllDept();

		return new ResponseEntity<List<DepartmentDTO>>(allDept, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Message> deleteDept(@PathVariable int id) {

		this.departmentService.deleteDept(id);
		Message mes= new Message("Department deleted sucessfully", true);
		return new ResponseEntity<Message>(mes , HttpStatus.ACCEPTED);
	}

	@GetMapping("/deptId/{dept}")
	public ResponseEntity<Department> findDepartment(@PathVariable String dept) {
		 Department findDepartmentCode2 = this.departmentService.findDepartmentCode(dept);

		return new ResponseEntity<Department>(findDepartmentCode2, HttpStatus.OK);
	}

}
