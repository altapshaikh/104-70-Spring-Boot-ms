package com.alt.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alt.DTO.ProductDTO;
import com.alt.Service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/to-json")
	public String generateJson() throws JsonProcessingException {
		ProductDTO productDTO =
				new ProductDTO(101,"refigerator",0.00,"samsung","X-YY101",new Date());
		String convertToJson = productService.convertToJson(productDTO);
		return convertToJson;
	}
	
	@GetMapping(value = "/to-object")
	public ProductDTO generateObject() throws JsonProcessingException {
	String json="{\r\n"
			+ "    \"id\": 101,\r\n"
			+ "    \"name\": \"refigerator\",\r\n"
			+ "    \"prize\": 25500.0,\r\n"
			+ "    \"brand\": \"samsung\"\r\n"
			+ "}";
		 ProductDTO convertToObject = productService.convertToObject(json);
		 System.out.println(convertToObject);
		return convertToObject;
	}
	
	
	
}
