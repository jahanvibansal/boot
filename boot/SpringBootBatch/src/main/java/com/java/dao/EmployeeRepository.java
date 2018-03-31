package com.java.dao;

import org.springframework.data.repository.CrudRepository;

import com.java.dto.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

}
