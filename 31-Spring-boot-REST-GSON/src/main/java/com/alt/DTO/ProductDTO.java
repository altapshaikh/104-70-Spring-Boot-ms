package com.alt.DTO;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
@SerializedName("product_id")
	private int id;

	private String name;
	private double prize;
	private String brand;
	private transient String productCode;
	private Date createdAt;
}





