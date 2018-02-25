package com.java.repository;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.java.model.Student;

@Component
@Profile("dev")
public class StudentInitializer implements CommandLineRunner, ApplicationRunner {

	@Autowired
	private javax.sql.DataSource datasource;

	@Autowired
	StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// Command line arguments
		String str = Arrays.stream(args).collect(Collectors.joining(","));
		System.out.println(str);

	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		String str = Arrays.stream(arg0.getSourceArgs()).collect(Collectors.joining(","));
		System.out.println(str);
		Student st1 = new Student("Payal", "");
		Student st2 = new Student("Ritu", "");
		Student st3 = new Student("Richa", "");
		Student st4 = new Student("Shreya", "");
		repository.save(st1);
		repository.save(st2);
		repository.save(st3);
		repository.save(st4);
		System.out.println(datasource);

	}

}
