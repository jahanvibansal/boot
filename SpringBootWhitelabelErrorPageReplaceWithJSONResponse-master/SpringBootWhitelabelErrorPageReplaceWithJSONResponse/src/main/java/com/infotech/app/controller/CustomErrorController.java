package com.infotech.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Value("${debug}")
    private boolean debug;

    @RequestMapping(value = PATH)
    ResponseEntity error(HttpServletRequest request, HttpServletResponse response) {
    	Error1 error= new Error1(response.getStatus(), "URL not correct");
    	  return new ResponseEntity(error, HttpStatus.BAD_GATEWAY);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
 
}