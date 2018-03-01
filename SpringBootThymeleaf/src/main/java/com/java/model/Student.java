package com.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
//@Table(catalog="test") : specify db name
public class Student {
	@Id
	@Min(1)
	private int stid;
	@NotNull
	@Size(min=3, max=30)
	private String name;
	@NotNull
	private String quote;
	
	public Student(int id,String name, String quotes) {
		super();
		this.stid= id;
		this.name = name;
		this.quote = quotes;
	}
	public Student() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	

}
