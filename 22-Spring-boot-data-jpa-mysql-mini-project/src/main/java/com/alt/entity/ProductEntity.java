package com.alt.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
  @Id
  @GeneratedValue
	private long id;
	private String productName;
	private String prize;
	private String model;
	private LocalDate mfd;
	private int warrnty;
	
}
