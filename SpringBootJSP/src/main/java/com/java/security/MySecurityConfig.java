package com.java.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	private AuthenticationManagerBuilder auth;

	protected void configure(HttpSecurity http) throws Exception {

	/*	http.csrf().disable()
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin().and()
			.httpBasic();*/
		
		http.csrf().disable().authorizeRequests().antMatchers("/students/**").hasRole("admin").and().formLogin();
		http.csrf().disable().authorizeRequests().antMatchers("/home/**").hasAnyRole("admin","user").and().formLogin();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception  {
		auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("admin");
		auth.inMemoryAuthentication().withUser("payal").password("payal123").roles("user");
	}
}
