package com.java.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.java.dao.EmployeeRepository;
import com.java.dto.Employee;

@Component
public class EmployeeInitializer implements CommandLineRunner {
	
	@Autowired EmployeeRepository repository;

	@Override
	public void run(String... arg0) throws Exception {
		repository.save(new Employee("Kanika", "kanika@gmail.com",65f));
	}

}
