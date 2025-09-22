package com.alt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alt.dto.ProductDTO;
import com.alt.service.ProductService;

import lombok.Delegate;

@RestController
public class ProductClientController {
     @Autowired
	private ProductService productService;
	
     @GetMapping(value="/fetchProduct")
	public ResponseEntity<List<ProductDTO>>getListOfPorduct(){
		List<ProductDTO> allProduct = productService.getAllProduct();
		System.out.println(allProduct);
		return ResponseEntity.ok(allProduct);
	}
     
     @GetMapping(value="/getProduct/{id}")
 	public ResponseEntity<ProductDTO>getListOfPorduct(@PathVariable("id")long id){
    	 ProductDTO productById = productService.getProductById(id);
 		System.out.println(productById);
 		return ResponseEntity.ok(productById);
 	}
	
     @PostMapping(value = "/create")
     public ResponseEntity<ProductDTO>registerProduct(@RequestBody ProductDTO product ){
    	 ProductDTO registerProduct = productService.registerProduct(product);
    	 return ResponseEntity.ok(registerProduct);
     }
     
     
     @PutMapping(value = "/update")
     public ResponseEntity<ProductDTO>updateProduct(@RequestBody ProductDTO product ){
    	 ProductDTO registerProduct = productService.updateProduct(product);
    	 return ResponseEntity.ok(registerProduct);
     }
     
     @DeleteMapping(value = "/delete/{id}")
     public ResponseEntity<String>deleteProduct(@PathVariable("id")long id){
    	  String deleteProduct = productService.deleteProduct(id);
    	 return ResponseEntity.ok(deleteProduct);
     }
     
     
}
