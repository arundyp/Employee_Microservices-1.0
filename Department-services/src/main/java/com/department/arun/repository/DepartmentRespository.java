package com.department.arun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.department.arun.entity.Department;

public interface DepartmentRespository  extends JpaRepository<Department, Integer>{
	
Department findByDepartmentCode(String deptNo);

}
