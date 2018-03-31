package com.infotech.app.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infotech.app.dto.UserInfo;
import com.infotech.app.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = repository.findOne(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRoles()[0]);
		User user_1 = new User(username, user.getPassword(), Arrays.asList(authority));
		UserDetails details = (UserDetails) user_1;
		return details;
	}

}
