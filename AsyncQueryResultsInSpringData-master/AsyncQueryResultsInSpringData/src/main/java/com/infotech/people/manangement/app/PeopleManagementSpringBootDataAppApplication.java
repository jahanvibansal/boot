package com.infotech.people.manangement.app;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.infotech.people.manangement.app.entities.Person;
import com.infotech.people.manangement.app.service.PeopleManagementService;

@SpringBootApplication
@EnableAsync
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner{

	@Autowired
	private PeopleManagementService peopleManagementService;
	
	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CompletableFuture<Person> completableFuture = peopleManagementService.findByEmail("maya.m2017@gmail.com");
		Person person = completableFuture.get(20, TimeUnit.SECONDS);
		System.out.println(person);
	}

}
