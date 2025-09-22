package com.alt.Service;

import org.springframework.stereotype.Service;

import com.alt.DTO.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {

	//java to json---------->serialization
	
	public String convertToJson(ProductDTO product) throws JsonProcessingException {
		
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(product);
		return json;
	}
	
	// json to java ---------->De-serialization
	
	public ProductDTO convertToObject(String json) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		ProductDTO product = mapper.readValue(json, ProductDTO.class);
		return product;
	}
}
