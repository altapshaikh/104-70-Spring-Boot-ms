package com.alt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/pay")
	public String pay() {
		return "payment processed sucessfully by instance running on port: _"+port;
	}
	
	
}
