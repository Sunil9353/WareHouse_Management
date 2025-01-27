package com.jsp.warehouse.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
	@Bean
	public PasswordEncoder  passwordEncoder() {
		
		return new  BCryptPasswordEncoder(12); //  12 time itteration 
	}
	
	@Bean
	public SecurityFilterChain  securityFilterChain(HttpSecurity httpSecurity ) throws Exception {
		
		return  httpSecurity.build();
		
	}

}
