package com.alt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.alt.Service.ProductService;

import com.alt.dto.ProductDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductDataController {
	
@Autowired
	private ProductService service;

	@GetMapping(value = "/product")
	public    Flux<ProductDTO>getAllData(){
		 Flux<ProductDTO> allProduct = service.getAllProduct();
		return allProduct;
		
	}
	
	@GetMapping(value = "/product/{id}")
	public    Mono<ProductDTO>getProductById(@PathVariable("id")Long id){
	 Mono<ProductDTO> productById = service.getProductById(id);
		return productById;
	}
	
	
	@PostMapping(value = "/register")
	public    Mono<ProductDTO>createProduct(@RequestBody ProductDTO dto){
	 Mono<ProductDTO> product = service.createProduct(dto);
		return product;
	}
	
	@PutMapping(value = "/update")
	public    Mono<ProductDTO>updateProduct(@RequestBody ProductDTO dto){
	 Mono<ProductDTO> product = service.updateProduct(dto);
		return product;
	}
	
}
