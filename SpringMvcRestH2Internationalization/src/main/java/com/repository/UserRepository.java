package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;

import com.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
