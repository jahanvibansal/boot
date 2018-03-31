package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/public").hasAnyRole("ADMIN","USER").
		antMatchers("/private").hasRole("ADMIN").
		and().formLogin();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication().withUser("ram").password("ram123").roles("ADMIN");
		  auth.inMemoryAuthentication().withUser("ravan").password("ravan123").roles("USER");
		  auth.inMemoryAuthentication().withUser("kans").password("kans123").roles("USER");
	}
	
	
	@Bean
	public PasswordEncoder getEncoder() {
		return   NoOpPasswordEncoder.getInstance();
	}
}  