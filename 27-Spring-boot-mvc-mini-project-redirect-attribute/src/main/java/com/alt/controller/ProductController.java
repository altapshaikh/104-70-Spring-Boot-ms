package com.alt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String saveProduct(@ModelAttribute("product")ProductDTO product,RedirectAttributes redicrectAttributes,
			                                                   Model model) {
		 ProductDTO registerProduct = productService.registerProduct(product);
		 redicrectAttributes.addFlashAttribute("msg", "product register sucessfully: "+registerProduct.getId());
		return "redirect:/list_product";
	}
	
	@GetMapping(value = "/list_product")
	public String getListOfProduct(Model model) {
		List<ProductDTO> allProduct = productService.fetchAllProduct();
		model.addAttribute("listProduct", allProduct);
		return "listproduct";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteProduct(@PathVariable("id")Long id,RedirectAttributes redicrectAttributes) {
		productService.deleteProduct(id);
		 redicrectAttributes.addFlashAttribute("msg", "product deleted sucessfully: "+id);
		return "redirect:/list_product";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editProduct(@PathVariable("id")Long id,Model model) {
		ProductDTO productById = productService.fetchProductById(id);
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		sd.format(new Date());
		productById.setMfd(sd);
		model.addAttribute("product", productById);
		model.addAttribute("type", ProductType.values());
		return "edit";
	}
	
	@PostMapping(value  = "/update")
	public String updateProduct(@ModelAttribute("product")ProductDTO product,Model model,RedirectAttributes redicrectAttributes) {
		 productService.updateProduct(product);
		 redicrectAttributes.addFlashAttribute("msg", "product updated sucessfully: "+product.getId());
		return "redirect:/list_product";
	}
	
}
