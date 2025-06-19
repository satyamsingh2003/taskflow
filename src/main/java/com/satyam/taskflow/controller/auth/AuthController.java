package com.satyam.taskflow.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyam.taskflow.dto.RegisterRequest;
import com.satyam.taskflow.entity.User;
import com.satyam.taskflow.service.AuthService;
import com.satyam.taskflow.utility.ResponseStructure;


@RestController
@RequestMapping("/auth")
public class AuthController {
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
}
