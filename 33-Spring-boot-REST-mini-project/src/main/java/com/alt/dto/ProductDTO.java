package com.alt.dto;

import java.time.LocalDate;

import com.alt.utility.ProductType;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class ProductDTO{
	@XmlElement
	private long id;
	@XmlElement
	private String name;
	@XmlElement
	private String brand;
	@XmlElement
	private int warantty;
	@XmlElement
	private int prize;
	@XmlElement
	private int quantity;
	@XmlElement
	private LocalDate mfd;
	@XmlElement
	private ProductType type;
}
