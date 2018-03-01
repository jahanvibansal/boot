package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.User;

public interface UserService {

	List<User> getUsers();

	User getUserById(int id);

	//void deleteUserById(int id);

	void deleteUser(User user);

	void updateOrCreateUser(User user);

}