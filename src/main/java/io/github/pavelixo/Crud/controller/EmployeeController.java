package io.github.pavelixo.Crud.controller;

import java.util.List;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.pavelixo.Crud.dto.CreateEmployeeDTO;
import io.github.pavelixo.Crud.model.Employee;
import io.github.pavelixo.Crud.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> listEmployees() {
		return employeeService.listEmployees();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> createEmployee(@Valid @RequestBody CreateEmployeeDTO request, BindingResult result) {
		if (!result.hasErrors()) 
			return ResponseEntity
					.ok(employeeService
							.createEmployee(request.getName(), request.getRoleId())
					);
		
        List<String> errors = result
        		.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        
        return ResponseEntity.badRequest().body(errors);
	}
}
