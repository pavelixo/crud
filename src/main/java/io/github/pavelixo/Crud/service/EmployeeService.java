package io.github.pavelixo.Crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.pavelixo.Crud.model.Employee;
import io.github.pavelixo.Crud.model.Role;
import io.github.pavelixo.Crud.repository.EmployeeRepository;
import io.github.pavelixo.Crud.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final RoleRepository roleRepository;
	
	public List<Employee> listEmployees() {
		 return employeeRepository.findAll();
	}
	
	public Employee createEmployee(String name, Long roleId) {
		Role role = roleRepository
				.findById(roleId)
				.orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado."));
		
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
