package io.github.pavelixo.Crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.pavelixo.Crud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
