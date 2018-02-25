package com.java.model;

import java.util.List;

public class Quotes {
	
	private String name;
	private List<String> quotes;
	public Quotes() {
		super();
	}
	public Quotes(String name, List<String> quotes) {
		super();
		this.name = name;
		this.quotes = quotes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}

}
