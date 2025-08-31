package com.alt.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.alt.utility.ProductType;

import lombok.Data;

@Data
public class ProductDTO{
	private long id;
	private String name;
	private String brand;
	private int warantty;
	private int prize;
	private int quantity;
	private SimpleDateFormat mfd;
	private ProductType type;
}
