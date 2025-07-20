package com.ait.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	@Tool(name = "test")
	public String registerEmployee(Integer id, String name, String role) {
		
		return "welcome to my world";
	}
}
