package com.alt.DTO;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement(name = "employee")
@XmlType(propOrder = {"id","salary","name","skills"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
@XmlAttribute
	private int id;
	private String name;
	private double salary;
	@XmlTransient
	private String password;
	@XmlElementWrapper
	private List<String> skills;
	//String password,
	public Employee(int id, String name, double salary, List<String> skills) {
		this.id = id;
		this.name = name;
	//	this.password = password;
		this.salary = salary;
		this.skills = skills;
	}

	public Employee() {

	}

	

	
}
