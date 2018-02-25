package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.java.model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer>{
	
	public List<Student> findByName(String name);
	
	public Page<Student> findByNameContaining(String name, Pageable p);

	/*@Query("from Student where marks > ?")
	public List<Student> findByQuote(String quote);
	*/
}
