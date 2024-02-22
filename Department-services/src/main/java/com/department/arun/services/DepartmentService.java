package com.department.arun.services;

import java.util.List;

import com.department.arun.entity.Department;
import com.department.arun.mapper.DepartmentDTO;

public interface DepartmentService {
	
	DepartmentDTO createDept(DepartmentDTO deptDTO);
	
	DepartmentDTO getDept(int id);
	
	DepartmentDTO updateDept(DepartmentDTO deptDTO, int id);
	
	List<DepartmentDTO> getAllDept();
	
	void deleteDept(int id);
	
	Department findDepartmentCode(String deptNo);

}
