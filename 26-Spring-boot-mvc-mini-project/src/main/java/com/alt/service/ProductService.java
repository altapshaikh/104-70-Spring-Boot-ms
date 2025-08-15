package com.alt.service;

import java.util.List;

import com.alt.dto.ProductDTO;

public interface ProductService {

	public ProductDTO registerProduct(ProductDTO product);
	
	public ProductDTO updateProduct(ProductDTO product);
	
	public ProductDTO fetchProductById(int id);
	
	public List<ProductDTO> fetchAllProduct();
	
	public void  deleteProduct();
	
	
}
