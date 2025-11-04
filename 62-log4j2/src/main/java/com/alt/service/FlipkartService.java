package com.alt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alt.DTO.Product;
import com.alt.controller.FlipkartController;

@Service
public class FlipkartService {
	
	private static final Logger LOG=LogManager.getLogger(FlipkartService.class);
	
	public List<Product>list=new ArrayList<>();
	
	public String registerProduct(Product product) {
		LOG.info("product id creation is started");
		Random r=new Random();
		int nextInt = r.nextInt(999);
		LOG.info("product id  is started {}",nextInt);
		product.setId((long) nextInt);
		list.add(product);
		LOG.info("product saved in database {}",product);
		return ""+product.getId();
	}
}
