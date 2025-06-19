package com.satyam.taskflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.satyam.taskflow.dto.RegisterRequest;
import com.satyam.taskflow.entity.User;
import com.satyam.taskflow.exceptions.UsernameAlreadyExistsException;
import com.satyam.taskflow.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User Register(RegisterRequest request) {
		if(userRepository.findByUsername(request.getUsername()).isPresent()) {
			throw new UsernameAlreadyExistsException("Username is already Present");
		}
		
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		return userRepository.save(user);

	}
}

