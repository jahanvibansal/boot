package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping("/private")
	public String getMessage1() {
		return "Hi Admin!";
	}
	@RequestMapping("/public")
	public String getMessage2() {
		return "Hi User!";
	}
}
