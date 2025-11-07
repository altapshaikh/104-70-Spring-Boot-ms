package com.ait.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String contactNo;
	private String password;
	private Date dob;
	private String gender;
	@Lob
    private byte[] profilePic;
}
