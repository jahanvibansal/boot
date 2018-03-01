package com.controller;

import java.util.List;

/*import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;*/
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.User;
import com.service.UserService;

// expose the 5 methods related to user object 


@Controller
@RequestMapping("/users")
public class UserController 
{
	@RequestMapping("/index")
	public String getIndex()
	{
		return "index";
	}
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping
	public List<User> getUser()
	{
		return userService.getUsers();
	}
	
	@ResponseBody				//@ResponseBody will convert java object to other types like text/html, json or xml
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User getUserById(@PathVariable("id")int id)
	{
		return userService.getUserById(id);
	}
	
	@RequestMapping(value= "/{id}", method=RequestMethod.DELETE) 
	@ResponseBody
	public void deleteUserById(@PathVariable("id") int id)
	{
		//userService.deleteUserById(id);
	}
	
	@DeleteMapping(consumes="application/json") 
	//@RequestBody will convert json to java object
	@ResponseBody
	public void deleteUser(@RequestBody User user)
	{
		System.out.println("user is "+ user);
		userService.deleteUser(user);
		throw new RuntimeException("Invalid user!!");
	}
	
	@PutMapping
	public void updateOrCreateUser(@RequestBody User user)
	{
		userService.updateOrCreateUser(user);
	}
	
/*	@ExceptionHandler(value= RuntimeException.class)
	public String displayError(Exception exception, Model model){
		model.addAttribute("exception", exception.getMessage());
		model.addAttribute("errorcode",404);
		return "errorPage";
	}*/
	
	/*@ExceptionHandler(value= Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public void displayError1(Exception exception, Model model){
	//ResponseEntity: status, body
	}
	
	@ExceptionHandler(value= Exception.class)
	@ResponseBody
	public Response displayError2(Exception exception, Model model){
	//ResponseEntity: status, body
		Error error= new Error(404, exception.getMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
	}*/
}


@XmlRootElement
class Error{
	int code;
	String message;
	public int getCode() {
		return code;
	}
	public Error(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}