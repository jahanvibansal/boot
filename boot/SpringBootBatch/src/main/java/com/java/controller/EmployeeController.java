package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dao.EmployeeRepository;
import com.java.dto.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired EmployeeRepository repository;
	
	@GetMapping
	public List<Employee> getEmployees() {
		return (List<Employee>) repository.findAll();
	}

}
