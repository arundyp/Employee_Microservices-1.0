package com.department.arun.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.department.arun.entity.Department;
import com.department.arun.exception.ResourceNotFoundException;
import com.department.arun.mapper.DepartmentDTO;
import com.department.arun.repository.DepartmentRespository;
import com.department.arun.services.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRespository departmentRespository;

	private ModelMapper mapper;

	@Override
	public DepartmentDTO createDept(DepartmentDTO deptDTO) {
		Department department = this.mapper.map(deptDTO, Department.class);
		this.departmentRespository.save(department);

		DepartmentDTO departmentDTO = this.mapper.map(department, DepartmentDTO.class);
		return departmentDTO;
	}

	@Override
	public DepartmentDTO getDept(int id) {
		Department department = this.departmentRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department is not present on server" + id));
		DepartmentDTO departmentDTO = this.mapper.map(department, DepartmentDTO.class);
		return departmentDTO;
	}

	@Override
	public DepartmentDTO updateDept(DepartmentDTO deptDTO, int id) {

		Department ExistDept = this.departmentRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department is not present on server" + id));

		ExistDept.setDept_name(deptDTO.getDept_name() != null ? deptDTO.getDept_name() : ExistDept.getDept_name());
		ExistDept.setDepartmentCode(
				deptDTO.getDepartmentCode() != null ? deptDTO.getDepartmentCode() : ExistDept.getDepartmentCode());
		ExistDept.setDescription(
				deptDTO.getDescription() != null ? deptDTO.getDescription() : ExistDept.getDescription());

		this.departmentRespository.save(ExistDept);

		DepartmentDTO departmentDTO = this.mapper.map(ExistDept, DepartmentDTO.class);

		return departmentDTO;
	}

	@Override
	public List<DepartmentDTO> getAllDept() {
		List<Department> findAll = this.departmentRespository.findAll();

		List<DepartmentDTO> list = findAll.stream().map((data) -> this.mapper.map(data, DepartmentDTO.class))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public void deleteDept(int id) {
		Department ExistDept = this.departmentRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department is not present on server" + id));

		this.departmentRespository.deleteById(id);

	}

	@Override
	public Department findDepartmentCode(String deptNo) {
		 Department findByDepartmentCode = this.departmentRespository.findByDepartmentCode(deptNo);
		return findByDepartmentCode;
	}

}
