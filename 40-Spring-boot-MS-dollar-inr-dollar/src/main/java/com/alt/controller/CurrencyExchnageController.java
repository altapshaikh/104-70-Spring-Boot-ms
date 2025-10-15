package com.alt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alt.service.ExchangeService;

@RestController
public class CurrencyExchnageController {

	private ExchangeService exchnageService;

	public CurrencyExchnageController(ExchangeService exchnageService) {
		this.exchnageService = exchnageService;
	}
	
	@GetMapping("/inr-to-dollar/{amount}")
	public ResponseEntity<String>convertInrToDollar(@PathVariable double amount){
		double dollar = exchnageService.convertInrToDollar(amount);
		return ResponseEntity.ok("converted INR: "+amount+" to doller: "+dollar);
	}
	
	
	@GetMapping("/dollar-to-inr/{amount}")
	public ResponseEntity<String>convertDollarToInr(@PathVariable double amount){
		double inr = exchnageService.convertDollarToInr(amount);
		return ResponseEntity.ok("converted doller: "+amount+" to INR: "+inr);
	}
	
	
	
	
}
