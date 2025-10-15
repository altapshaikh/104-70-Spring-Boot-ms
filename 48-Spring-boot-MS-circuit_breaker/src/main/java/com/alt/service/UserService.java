package com.alt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alt.dto.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class UserService {

	@Autowired
	ExternalUserService externalUserService;
	
	@CircuitBreaker(name="userService", fallbackMethod = "getUserFallback")
	public User getUserById(Long id) {
		User userById = externalUserService.getUserById(id);
		return userById;
	}
	
	@CircuitBreaker(name="userService", fallbackMethod = "getAllUsersFallback")
	@TimeLimiter(name="userService")
	public 	List<User>  getAllUser() {
		List<User> allUser = externalUserService.getAllUserById();
		return allUser;
	}
	
	public User getUserFallback(Long id, Exception ex) {
		return new User(id, "raja"+id, "raja@gmail.com");
	}
	
	public List<User> getAllUsersFallback(Exception ex){
		return List.of(
				 new User(11l, "john", "john@gmail.com"),
				 new User(211l, "dev","dev@gmail.com")
				);
	}
	
	
}
