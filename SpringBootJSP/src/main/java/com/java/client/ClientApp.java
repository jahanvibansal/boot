package com.java.client;

import java.util.HashMap;
import java.util.Map;

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
	
		SpringApplication app=new SpringApplication(ClientApp.class);
		Map<String,Object> configMap= new HashMap<>();
		configMap.put("SERVER_PORT", 8585);
		app.setDefaultProperties(configMap);
		/*app.setBanner(new Banner() {

			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.println("===============My customized banner=================================");
				
			}
			
		});*/
		app.run(args);
	}

}
