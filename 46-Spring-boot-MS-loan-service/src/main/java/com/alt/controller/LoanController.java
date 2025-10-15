package com.alt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class LoanController {
     @Autowired
	RestTemplate restTemplate;
     
     
	@GetMapping("/emi")
	public ResponseEntity<String> deductEmi() {
		String response = restTemplate.getForObject("http://account-service/deduct", String.class);
		return ResponseEntity.ok("emi deducted from account service"+response);
	}
	

}
