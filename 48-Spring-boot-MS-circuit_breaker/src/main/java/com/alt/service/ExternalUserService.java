package com.alt.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.alt.dto.User;

@Service
public class ExternalUserService {

	private final Random random=new Random();
	
	public User getUserById(Long id) {
		
		if(random.nextInt(10)<7) {
			throw new RuntimeException("Get user by id failed");
		}
		
		try {
			Thread.sleep(15000);
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		return new User(id, "User"+id, id+"@gmail.com");
	}
	
	public List<User> getAllUserById() {
		if(random.nextInt(10)<7) {
			throw new RuntimeException("Get user by id failed");
		}
		
		try {
			Thread.sleep(500+random.nextInt(1000));
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return List.of(
				 new User(1l, "Raja", "Raja@gmail.com"),
				 new User(2l, "rani","rani@gmail.com")
				);
		
	}
	
	
	
}
