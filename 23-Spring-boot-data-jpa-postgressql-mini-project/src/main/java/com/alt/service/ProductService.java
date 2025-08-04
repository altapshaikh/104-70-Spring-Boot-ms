package com.alt.service;

import java.util.List;

import com.alt.entity.ProductEntity;

public interface ProductService {

	public ProductEntity saveProduct(ProductEntity product);
	
	public ProductEntity updateProduct(ProductEntity product);
	
	public void deleteProduct(String id);
	
	public ProductEntity fetchProductById(String id);
	
	public List<ProductEntity> fetchAllProduct();
}
