package com.alt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alt.dto.ProductDTO;
import com.alt.service.ProductService;

@RestController
public class ProductController {
	
			@Autowired
	private ProductService productService;

	@PostMapping(value  = "/register", name="register the product")
	public ProductDTO  saveProduct(@RequestBody ProductDTO product) {
		 ProductDTO registerProduct = productService.registerProduct(product);
		return registerProduct;
	}
	
	@GetMapping(value = "/list_product")
	public List<ProductDTO> getListOfProduct() {
		List<ProductDTO> allProduct = productService.fetchAllProduct();
		return allProduct;
	}
	
	@GetMapping(value = "/delete/{id}")
	public Map<String, String> deleteProduct(@PathVariable("id")Long id) {
		Map<String, String>map=new HashMap<>();
		productService.deleteProduct(id);
		map.put("msg","product deleted sucessfully: "+id);
	    return map;
	}
	
	@GetMapping(value = "/edit/{id}")
	public ProductDTO editProduct(@PathVariable("id")Long id) {
		ProductDTO productById = productService.fetchProductById(id);
		return productById;
	}
	
	@PostMapping(value  = "/update")
	public ProductDTO updateProduct( @RequestBody  ProductDTO product) {
		ProductDTO updateProduct = productService.updateProduct(product);
		return updateProduct;
	}
	
}
