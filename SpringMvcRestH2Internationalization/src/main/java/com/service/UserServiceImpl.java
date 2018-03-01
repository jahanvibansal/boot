package com.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.User;
import com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private  UserRepository repository;
	
	@PostConstruct
	public void init()
	{
		User user1= new User(1, "Payal", "jahanvi.bansal@gmail.com");
		User user2= new User(2, "Ritu", "rity@gmail.com");
		User user3= new User(3, "Shikha", "shikha@gmail.com");
		User user4= new User(4, "Anju", "anju@gmail.com");
		
		repository.save(user1);
		repository.save(user2);
		repository.save(user3);
		repository.save(user4);
	}
	@Override
	public List<User> getUsers()
	{
		System.out.println("getUser() is called");
		return (List<User>) repository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.service.UserService1#getUserById(int)
	 */
	@Override
	public User getUserById(int id)
	{
		System.out.println("User whose id is"+ id+" has be retrieved." );
		return repository.findById(id).get();
	}
	
	/* (non-Javadoc)
	 * @see com.service.UserService1#deleteUserById(int)
	 */
	
	/*@Override
	public void deleteUserById(int id)
	{
		System.out.println("User with id "+id +"has been deleted using deleteUserById().");
		repository.delete(id);
	}*/
	
	/* (non-Javadoc)
	 * @see com.service.UserService1#deleteUser(com.dto.User)
	 */
	@Override
	public void deleteUser(User user)
	{
		System.out.println("User with id "+ user.getId() + "has been deleted using deleteUser().");
		repository.delete(user);
	}

	/* (non-Javadoc)
	 * @see com.service.UserService1#updateOrCreateUser(com.dto.User)
	 */
	@Override
	public void updateOrCreateUser(User user)
	{	
		System.out.println("User has been updated or created.");
//		repository.save(user);
		repository.saveAndFlush(user);
	}
	
	
	
	
}
