package com.java.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.java.model.Student;
import com.java.repository.StudentRepository;

@SpringBootApplication
@ComponentScan(basePackages="com.java")
@EnableJpaRepositories(basePackageClasses=StudentRepository.class)
@EntityScan(basePackageClasses=Student.class)
public class ClientApp {


	
	public static void main(String[] args) {
		SpringApplication.run(ClientApp.class, args);
	}

}
