package com.alt.dto;

import lombok.Data;

@Data
public class ProductDTO {
	public int id;
    public String name;
    public String brand;
    public int warantty;
    public int prize;
    public int quantity;
    public String mfd;
    public String type;
}
