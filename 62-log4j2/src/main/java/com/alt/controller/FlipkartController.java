package com.alt.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alt.DTO.Product;
import com.alt.service.FlipkartService;

@RestController
public class FlipkartController {
	
	private static final Logger LOG=LogManager.getLogger(FlipkartController.class);
	
	
@Autowired
	private FlipkartService service;
	@PostMapping
	public String createProduct(@RequestBody Product product) {
		LOG.info("request in create product.......");
		String registerProduct = service.registerProduct(product);
		LOG.info("product created sucessfully.......");
		return "product register sucessfully............!!!"+registerProduct;
	}
}
