package com.alt.serviceImpl;

import org.springframework.stereotype.Service;

import com.alt.dto.LoginDTO;
import com.alt.exception.UserNotFoundException;

@Service
public class LoginServiceImpl {

	public String valiateUser(LoginDTO loginDTO) {
		if (loginDTO.getEmail().equalsIgnoreCase("hacker@gmail.com") && loginDTO.getPassword().equals("hacker123")) {
			return "1";
		} else {
			throw new UserNotFoundException(loginDTO.getEmail() + " this user is not found..!! ");
		}

	}

}
