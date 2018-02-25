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
		Student st1 = new Student("Payal", "3543");
		Student st2 = new Student("Ritu", "3543");
		Student st3 = new Student("Richa", "454");
		Student st4 = new Student("Shreya", "34534");
		repository.save(st1);
		repository.save(st2);
		repository.save(st3);
		repository.save(st4);
		System.out.println(datasource);

	}

}
