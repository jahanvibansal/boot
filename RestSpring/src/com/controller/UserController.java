package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.User;
import com.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@ResponseBody
	@RequestMapping(produces= "application/json")
	public List<User> getUsers() {
		return service.getUsers();
	}
}
