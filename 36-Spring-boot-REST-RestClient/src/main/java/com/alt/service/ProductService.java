package com.alt.service;

import java.util.List;

import com.alt.dto.ProductDTO;

public interface ProductService {

	public List<ProductDTO>getAllProduct();
	public ProductDTO getProductById(long id);
	public ProductDTO registerProduct(ProductDTO  product);
	
	public ProductDTO updateProduct(ProductDTO  product);
	
	public String deleteProduct(Long id);
}
