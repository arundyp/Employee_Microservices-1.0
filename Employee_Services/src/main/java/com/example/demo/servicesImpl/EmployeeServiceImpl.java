package com.example.demo.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.exception.RespourceNotFoundException;
import com.example.demo.mapper.EmployeeDTO;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeServices {

	private EmployeeRepository employeeRepository;
	private ModelMapper mapper;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO emp) {

		Employee employee = this.mapper.map(emp, Employee.class);

		Optional<Employee> findByEmail = this.employeeRepository.findByEmail(emp.getEmail());

		if (findByEmail.isPresent()) {
			throw new EmailAlreadyExistsException("Email is already registered: " + emp.getEmail());
		}

		this.employeeRepository.save(employee);
		EmployeeDTO employeeDTO = this.mapper.map(employee, EmployeeDTO.class);
		return employeeDTO;
	}

	@Override
	public EmployeeDTO getSingleEmployee(int id) {

		Employee orElseThrow = this.employeeRepository.findById(id)
				.orElseThrow(() -> new RespourceNotFoundException("Resource not found"));

		EmployeeDTO map = this.mapper.map(orElseThrow, EmployeeDTO.class);
		return map;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {

		List<Employee> findAll = this.employeeRepository.findAll();
		List<EmployeeDTO> collect = findAll.stream().map((emp) -> this.mapper.map(emp, EmployeeDTO.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public Employee updateEmployee(Employee emp, int id) {
		Employee exist = this.employeeRepository.findById(id)
				.orElseThrow(() -> new RespourceNotFoundException("Resource not found"));
		exist.setName(emp.getName() != null ? emp.getName() : exist.getName());
		exist.setAddress(emp.getAddress() != null ? emp.getAddress() : exist.getAddress());
		exist.setEmail(emp.getEmail() != null ? emp.getEmail() : exist.getEmail());
		exist.setPassword(emp.getPassword() != null ? emp.getPassword() : exist.getPassword());
		exist.setDepartmentCode(emp.getDepartmentCode() != null ? emp.getDepartmentCode() : exist.getDepartmentCode());

		Employee employee = this.employeeRepository.save(exist);

		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		Employee orElseThrow = this.employeeRepository.findById(id)
				.orElseThrow(() -> new RespourceNotFoundException("Resource not found"));

		this.employeeRepository.delete(orElseThrow);
	}

}
