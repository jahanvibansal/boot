package com.infotech.people.manangement.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.people.manangement.app.dao.PeopleManangementDao;
import com.infotech.people.manangement.app.entities.Person;

@Service
public class PeopleManagementService {

	@Autowired
	private PeopleManangementDao peopleManangementDao;

	public CompletableFuture<Person> findByEmail(String email) {
		return peopleManangementDao.findByEmail(email);
	}

}
