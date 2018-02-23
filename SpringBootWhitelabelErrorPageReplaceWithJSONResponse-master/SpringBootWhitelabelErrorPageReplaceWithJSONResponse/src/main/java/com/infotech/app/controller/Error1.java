package com.infotech.app.controller;

public class Error1 {

	int status;
	String message;
	public Error1(int status, String string) {
		this.status= status;
		this.message= string;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
