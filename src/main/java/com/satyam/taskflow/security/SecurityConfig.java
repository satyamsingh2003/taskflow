package com.satyam.taskflow.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
    @Bean
     PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
    }
    
    @Bean
     SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    			http.csrf(csrf->csrf.disable())
    			.authorizeHttpRequests(auth->auth.requestMatchers("/auth/**","/swagger-ui/**",    
    			        "/v3/api-docs/**",    
    			        "/swagger-resources/**",
    			        "/webjars/**")
    			.permitAll()
    			.anyRequest().authenticated())
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
				http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
				return http.build();
    }
        
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
    	return config.getAuthenticationManager();
    }
}
