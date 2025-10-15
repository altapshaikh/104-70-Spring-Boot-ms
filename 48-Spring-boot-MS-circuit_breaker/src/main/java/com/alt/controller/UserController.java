package com.alt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alt.dto.User;
import com.alt.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<User>getUserById(@PathVariable Long id){
		 User userById = userService.getUserById(id);
		 return ResponseEntity.ok(userById);
	}
	
	
	
	
	
	
	
	
	
	
	
}
