package com.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	
	@ExceptionHandler(value= RuntimeException.class)
	public String displayError(Exception exception, Model model){
		model.addAttribute("errorMessage", exception.getMessage());
		model.addAttribute("errorcode",404);
		System.out.println("Exception handler code...");
		return "errorPage";
	}

}
