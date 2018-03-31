package com.java;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.java.dao.EmployeeRepository;
import com.java.dto.Employee;

@SpringBootApplication
@EntityScan(basePackageClasses=Employee.class)
@EnableJpaRepositories(basePackageClasses=EmployeeRepository.class)
@EnableBatchProcessing
public class MyClient {

	public static void main(String[] args) {
		SpringApplication.run(MyClient.class, args);
	}

}
