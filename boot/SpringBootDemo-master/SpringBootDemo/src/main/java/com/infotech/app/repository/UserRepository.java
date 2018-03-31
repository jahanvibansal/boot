package com.infotech.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.infotech.app.dto.UserInfo;

public interface UserRepository extends CrudRepository<UserInfo, String>{

}
