package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.User;

public interface UserService {

	public List<User> getUsers();

}
