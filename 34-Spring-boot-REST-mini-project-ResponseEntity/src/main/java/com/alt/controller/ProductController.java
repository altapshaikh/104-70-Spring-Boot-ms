package com.alt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	@PostMapping(value  = "/register",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProductDTO>  saveProduct(@RequestBody ProductDTO product) {
		 ProductDTO registerProduct = productService.registerProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(registerProduct);
	}
	
	@GetMapping(value = "/list_product",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<ProductDTO>> getListOfProduct() {
		List<ProductDTO> allProduct = productService.fetchAllProduct();
		return ResponseEntity.ok(allProduct);
	}
	
	@GetMapping(value = "/delete/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public  ResponseEntity<Map<String, String>> deleteProduct(@PathVariable("id")Long id) {
		Map<String, String>map=new HashMap<>();
		productService.deleteProduct(id);
		map.put("msg","product deleted sucessfully: "+id);
	    return ResponseEntity.ok(map);
	}
	
	@GetMapping(value = "/edit/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProductDTO> editProduct(@PathVariable("id")Long id) {
		ProductDTO productById = productService.fetchProductById(id);
		if(productById.getId()==id) {
			return ResponseEntity.ok(productById);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping(value  = "/update",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProductDTO> updateProduct( @RequestBody  ProductDTO product) {
		ProductDTO updateProduct = productService.updateProduct(product);
		return ResponseEntity.ok(updateProduct);
	}
	
}
