package com.java.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.java.model.Student;

@Component
public class StudentInitializer implements CommandLineRunner {

	@Autowired
	private javax.sql.DataSource datasource;

	@Autowired
	StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {
		Student st1 = new Student(1,"Payal", "");
		Student st2 = new Student(2,"Ritu", "");
		Student st3 = new Student(3,"Richa", "");
		Student st4 = new Student(4,"Shreya", "");
		repository.save(st1);
		repository.save(st2);
		repository.save(st3);
		repository.save(st4);
		System.out.println(datasource);

	}

}
