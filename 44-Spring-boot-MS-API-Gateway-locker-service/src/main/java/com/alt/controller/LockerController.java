package com.alt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locker")
public class LockerController {

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to locker service";
	}
}
