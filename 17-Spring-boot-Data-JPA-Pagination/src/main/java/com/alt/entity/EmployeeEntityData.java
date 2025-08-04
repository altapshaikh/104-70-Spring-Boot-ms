package com.alt.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Table(name = "employee")
public class EmployeeEntityData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empid", nullable = false, length = 100)
	private int employeeId;
	private String name;
	private String dept;
	@Column(name = "mobileno", updatable = false)
	private Long employeeContactNo;
	private int salary;
	private String address;
	@CreationTimestamp
	@Column(insertable = false)
	private Date recordCreated;

}
