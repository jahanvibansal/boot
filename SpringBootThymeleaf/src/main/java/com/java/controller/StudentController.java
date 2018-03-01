package com.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Student;
import com.java.repository.StudentRepository;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Value("${message}")
	private String message;
	
	@Autowired
	public StudentRepository repository;
	
	@GetMapping
	@ResponseBody
	public Page<Student> getStudentsPerPage(@RequestParam(value="page", required=false) Integer page, 
			@RequestParam(value="size", required=false) Integer size,
			@RequestParam(value="namelike", required=false) String name){
		System.out.println("Number of elements"+ size);
		if(page!= null && size!= null)
		return repository.findAll(new PageRequest(page, size, new Sort(Direction.ASC, "name") ));
		else if(name != null ) {
			return repository.findByNameContaining(name, new PageRequest(0, Integer.MAX_VALUE));
		}else
			return repository.findAll(new PageRequest(0, Integer.MAX_VALUE));
		//page.getContent() returns list
	}
	
	@GetMapping("/{name}")
	@ResponseBody
	public List<Student> getStudentByName(@PathVariable("name") String name){
		System.out.println("Fetching data for "+ name);
		return repository.findByName(name);
	}
	
	@GetMapping("/update")
	public String updateStudent(ModelMap model){
		model.addAttribute("student", new Student());
		return "studentsInfo";
	}
	
	
	@PostMapping
	public ModelAndView updateStudent(@Valid Student student, BindingResult result) {
		System.out.println(student.getStid());
		repository.save(student);
		return new ModelAndView("student");
	}
	
	@DeleteMapping("/{name}")
	public ResponseEntity deleteStudent(@PathVariable("name")String name) {
		List<Student> students= repository.findByName(name);
		repository.delete(students);
		return new ResponseEntity(HttpStatus.OK);
	}
}
