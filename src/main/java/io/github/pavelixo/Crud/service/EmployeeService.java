package io.github.pavelixo.Crud.service;

import org.springframework.stereotype.Service;

import io.github.pavelixo.Crud.model.Employee;
import io.github.pavelixo.Crud.model.Role;
import io.github.pavelixo.Crud.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	public Employee createEmployee(String name, Role role) {
		return employeeRepository
				.save(initializeEmployee(name, role));
	}
	
	private Employee initializeEmployee(String name, Role role) {
		return Employee
				.builder()
				.name(name)
				.role(role)
				.build();
	}
}
