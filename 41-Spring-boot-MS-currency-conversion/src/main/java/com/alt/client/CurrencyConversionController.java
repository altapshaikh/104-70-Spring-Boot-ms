package com.alt.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

	private final CurrencyExchnageClient exchangeClient;

	public CurrencyConversionController(CurrencyExchnageClient exchangeClient) {
		this.exchangeClient = exchangeClient;
	}
	
	
	@GetMapping("/inr-to-dollar/{amount}")
	public ResponseEntity<String>convertInrToDollar(@PathVariable double amount){
		String msg = exchangeClient.getInrToDollar(amount);
		return ResponseEntity.ok(msg);
	}
	
	
	@GetMapping("/dollar-to-inr/{amount}")
	public ResponseEntity<String>convertDollarToInr(@PathVariable double amount){
		String msg = exchangeClient.getDollarToInr(amount);
		return ResponseEntity.ok(msg);
	}
	
	
}
