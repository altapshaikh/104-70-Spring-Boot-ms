package com.alt.service;

import java.io.StringReader;
import java.io.StringWriter;

import org.springframework.stereotype.Service;

import com.alt.DTO.Employee;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Service
public class JaxBService {

	//marshalling
	public String marshalling(Employee employee) throws JAXBException {
		//jaxb context
		JAXBContext jAXBInstance = JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = jAXBInstance.createMarshaller();
		
		//java---->xml
		StringWriter writer=new StringWriter();
		marshaller.marshal(employee, writer);
		
		return writer.toString();
	}
	
	
	
	//unmarshalling
	
	public Employee unmarshall(String xml) throws JAXBException {
		JAXBContext jAXBInstance = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jAXBInstance.createUnmarshaller();
		
		StringReader reader=new StringReader(xml);
		Employee unmarshal = (Employee) unmarshaller.unmarshal(reader);
		return unmarshal;
	}
	
}
