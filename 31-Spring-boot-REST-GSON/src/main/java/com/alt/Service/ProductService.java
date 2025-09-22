package com.alt.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alt.DTO.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class ProductService {

	//java to json---------->serialization
	
	public String convertToJson(ProductDTO product) throws JsonProcessingException {
	//	Gson gson=new Gson();
		
		Gson gson=new GsonBuilder()
				.setDateFormat("yyyy-MM-dd HH:mm")
				.setPrettyPrinting().create();
		
		
		String json = gson.toJson(product);
		System.out.println(json);
		
		//for collections
		List<String>skills=Arrays.asList("java","aws", "sbms","design pattern");
		
				String skillsJson = gson.toJson(skills);
		System.out.println(skillsJson);
		return json;
	}
	
	// json to java ---------->De-serialization
	
	public ProductDTO convertToObject(String json) throws JsonProcessingException {
		Gson gson=new Gson();
		ProductDTO fromJson = gson.fromJson(json, ProductDTO.class);
		return fromJson;
	}
}
