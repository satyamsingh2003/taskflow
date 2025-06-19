package com.satyam.taskflow.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyam.taskflow.dto.LoginRequest;
import com.satyam.taskflow.dto.LoginResponse;
import com.satyam.taskflow.dto.RegisterRequest;
import com.satyam.taskflow.entity.User;
import com.satyam.taskflow.security.CustomUserDetailsService;
import com.satyam.taskflow.security.JwtUtil;
import com.satyam.taskflow.service.AuthService;
import com.satyam.taskflow.utility.ResponseStructure;


@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
@Autowired
private AuthService authService;	
@PostMapping("/register")
public ResponseEntity<ResponseStructure<User>> register(@RequestBody RegisterRequest request){
	ResponseStructure<User> rs = new ResponseStructure<User>();
	rs.setStatuscode(HttpStatus.ACCEPTED.value());
	rs.setMessage("User Object Created Successfully");
	rs.setData(authService.Register(request));
	return new ResponseEntity<ResponseStructure<User>>(rs,HttpStatus.ACCEPTED);
}

@PostMapping("/login")
public ResponseEntity<?> login (@RequestBody LoginRequest request){
	try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
	}catch(Exception e){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials ");
	}
	final UserDetails userDetails= userDetailsService.loadUserByUsername(request.getUsername());
	final String token = jwtUtil.generateToken(userDetails);
	return ResponseEntity.ok(new LoginResponse(token));
}
}
