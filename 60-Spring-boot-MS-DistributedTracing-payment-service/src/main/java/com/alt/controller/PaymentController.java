package com.alt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("payment")
public class PaymentController {
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping("/process")
	public String processPayment() {
		return "payment sucess...!!!" +
				restTemplate.getForObject("http://localhost:4547/notification/send", String.class);
		
	}
}
