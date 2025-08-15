package com.alt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alt.dto.ProductDTO;
import com.alt.service.ProductService;
import com.alt.utility.ProductType;

@Controller
public class ProductController {
	
@Autowired
	private ProductService productService;


	@GetMapping(name = "/")
	public String getRegistrationPage(Model model) {
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("type", ProductType.values());
		return "register";
	}
	
	@PostMapping(value  = "/register", name="register the product")
	public String saveProduct(@ModelAttribute("product")ProductDTO product,Model model) {
		 productService.registerProduct(product);
		return "redirect:/list_product";
	}
	
	@GetMapping(value = "/list_product")
	public String getListOfProduct(Model model) {
		List<ProductDTO> allProduct = productService.fetchAllProduct();
		model.addAttribute("listProduct", allProduct);
		return "listproduct";
	}
	
	
}
