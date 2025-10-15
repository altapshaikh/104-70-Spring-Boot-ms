package com.alt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DemoController {

	@Value("${message}")
	String message;
	@Value("${spring.datasource.username}")
	String username;
	@Value("${spring.datasource.password}")
	String password;
	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.datasource.driver-class-name}")
	String driver;
	
	
	@GetMapping
	public Map<String, String>getConfgiurationDetails(){
		Map<String, String>map=new HashMap<>();
		map.put("message", message);
		map.put("spring.datasource.username", username);
		map.put("spring.datasource.password", password);
		map.put("spring.datasource.url", url);
		map.put("spring.datasource.driver-class-name", driver);
		
		return map;
		
	}
	
	
}
