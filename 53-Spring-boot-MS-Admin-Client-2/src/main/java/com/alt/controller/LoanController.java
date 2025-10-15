package com.alt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	@GetMapping("/msg")
	public String getWishMsg() {
		return "welcome from loan Service.....!!!";
	}
}
