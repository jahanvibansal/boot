package com.infotech.app;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//Roles defined in secured attribute
	@Secured(value="admin")
	@GetMapping(value="/hello")
	public String welcome(){
		return "Welcome to Spring boot world!!";
	}
}
