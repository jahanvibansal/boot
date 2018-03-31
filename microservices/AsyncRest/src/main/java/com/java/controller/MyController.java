package com.java.controller;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.service.MyCallable2;

@RestController
@RequestMapping("/data")
public class MyController {

	/*Returning Callable implies that Spring MVC will invoke the task defined in the 
	 * Callable in a different thread. Spring will manage this thread by using a 
	 * TaskExecutor. Before waiting for the long task to finish, the servlet thread 
	 * will be released.*/
	@GetMapping
	public Callable<Integer> getData() {
		System.out.println(System.currentTimeMillis()+"*");
		Callable<Integer> callable= new MyCallable2();
		System.out.println(System.currentTimeMillis()+"*");
		return callable;
	}
}
