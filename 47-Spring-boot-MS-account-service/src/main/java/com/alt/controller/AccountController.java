package com.alt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	private int balacne = 1000;

	@GetMapping("/deduct")
	public String deductEmi() {
		balacne = balacne - 100;
		return "emi deducted for 100 and remainig balance is: " + balacne;
	}

}
