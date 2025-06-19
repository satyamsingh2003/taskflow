package com.satyam.taskflow.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
     PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
    }
    @Bean
     SecurityFilterChain filter(HttpSecurity http) throws Exception{
    	return http.csrf(csrf->csrf.disable())
    			.authorizeHttpRequests(auth->auth.requestMatchers("/auth/**")
    			.permitAll()
    			.anyRequest().authenticated())
				.sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
    }
}
