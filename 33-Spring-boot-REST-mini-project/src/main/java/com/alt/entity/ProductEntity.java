package com.alt.entity;

import java.time.LocalDate;

import com.alt.utility.ProductType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String brand;
	private int warantty;
	private int prize;
	private int quantity;
	private LocalDate mfd;
	@Enumerated(EnumType.STRING)
	private ProductType type;
}
