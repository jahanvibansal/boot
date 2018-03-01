package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.User;
import com.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository dao;
	
	public List<User> getUsers() {
		
		return (List<User>) dao.findAll();
	}

}
