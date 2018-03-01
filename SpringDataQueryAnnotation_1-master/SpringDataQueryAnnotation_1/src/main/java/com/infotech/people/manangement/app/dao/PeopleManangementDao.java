package com.infotech.people.manangement.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infotech.people.manangement.app.entities.Person;

public interface PeopleManangementDao extends CrudRepository<Person, Integer>{
	
	@Query(value="SELECT p FROM Person p WHERE p.lastName=?1")
	List<Person> getPeronInfoByLastName(String lastName);
	
	@Query(value="SELECT p FROM Person p WHERE p.firstName=?1 AND email=?2")
	List<Person> findByFirstNameAndEmail(String firstName,String email);
}
