package com.java.util.batch;

import org.springframework.batch.item.ItemProcessor;

import com.java.dto.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee>{

	@Override
	public Employee process(Employee employee) throws Exception {
		String name=employee.getName().toUpperCase();
		String emailId= employee.getEmailId().toUpperCase();
		float marks= (float) (employee.getMarks()*3.8);
		return new Employee(name, emailId, marks);
		
	}


}
