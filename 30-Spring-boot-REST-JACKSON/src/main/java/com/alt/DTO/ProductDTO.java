package com.alt.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) 
//@JsonIgnoreProperties({"brand","productCode"})

@JsonPropertyOrder({"product_id","brand","prize","name"})
public class ProductDTO {
	
	@JsonProperty("product_id")
	private int id;
	@JsonProperty
	private String name;

	private double prize;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String brand;
	
	@JsonIgnore
	private String productCode;
	
	@JsonFormat(shape = Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
}





