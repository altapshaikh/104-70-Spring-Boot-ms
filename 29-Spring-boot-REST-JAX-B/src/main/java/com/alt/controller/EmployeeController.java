package com.alt.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alt.DTO.Employee;
import com.alt.service.JaxBService;

import jakarta.xml.bind.JAXBException;

@RestController
public class EmployeeController {
	
	
	@Autowired
	JaxBService jaxbService;
	
	
	@GetMapping(value = "/marshalling")
	public String marshal() throws JAXBException {
		
		Employee employee = new Employee(101,"raja",
				1000.3,Arrays.asList("java","springboot","aws"));
		
		String marshalling = jaxbService.marshalling(employee);
		return marshalling;
	}
	
	@GetMapping(value = "/unmarshalling")
	public Employee unmarshal() throws JAXBException {
		//+ "    <password>admin123</password>\r\n"
		String xml="<employee>\r\n"
				+ "    <id>101</id>\r\n"
				+ "    <salary>1000.3</salary>\r\n"
				+ "    <name>raja</name>\r\n"			
				+ "    <skills>\r\n"
				+ "        <skills>java</skills>\r\n"
				+ "        <skills>springboot</skills>\r\n"
				+ "        <skills>aws</skills>\r\n"
				+ "    </skills>\r\n"
				+ "</employee>";
		
		Employee unmarshall = jaxbService.unmarshall(xml);
		System.out.println(unmarshall);
		return unmarshall ;
	}
}
