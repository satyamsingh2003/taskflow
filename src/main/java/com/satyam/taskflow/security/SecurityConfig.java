package com.satyam.taskflow.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable() // Disable CSRF for Postman/JWT-based login
	            .authorizeHttpRequests()
	                .requestMatchers("/auth/**").permitAll() // Public routes
	                .anyRequest().authenticated() // All other routes secured
	            .and()
	            .httpBasic(); // Temporary: allows basic auth

	        return http.build();
}
	 }
