package com.ait.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserBean {
	private int id;

	private String name;
	private String email;
	private String contactNo;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // Match HTML input format
	private Date dob;
	private String gender;
}
