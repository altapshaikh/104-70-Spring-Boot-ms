package com.alt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alt.dto.LoginDTO;
import com.alt.dto.ProductDTO;
/*import com.alt.exception.ResourceNotFoundException;
import com.alt.exception.UserNotFoundException;*/
import com.alt.service.ProductService;
import com.alt.serviceImpl.LoginServiceImpl;
import com.alt.utility.ProductType;
import com.alt.utility.RestConstant;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProductController {
	
@Autowired
	private ProductService productService;
@Autowired
private LoginServiceImpl loginService;

	@GetMapping(value = RestConstant.REGISTER)
	public String getRegistrationPage(Model model,HttpServletRequest req) {
		HttpSession session2 = req.getSession();
		System.out.println(session2);
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("type", ProductType.values());
		return "register";
	}
	
	
	@GetMapping(value = RestConstant.LOGIN_PAGE)
	public String login(Model model) {
		model.addAttribute("login", new LoginDTO());
		return "login";
	}
	
	@PostMapping(value = RestConstant.LOGIN)
	public String loginUser(@Valid @ModelAttribute("login")LoginDTO loginDTO,
			BindingResult rs,
			Model model,HttpSession session, RedirectAttributes  ra) {
		
			try {
				if(rs.hasErrors()) {		
					model.addAttribute("login",loginDTO);
					return "login";
				}
				
				
				String valiateUser = loginService.valiateUser(loginDTO);
			/*
			 * Cookie cookieObj=new Cookie("email", "hacker@gmail.com");
			 * res.addCookie(cookieObj);
			 */
			
		
			session.setAttribute("user", loginDTO.getEmail());
			//session.setMaxInactiveInterval(25);
			
			return "redirect:/list_product";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", e.getMessage());
			return "redirect:/";
		} 
	}
	
	
	@PostMapping(value  = "/register", name="register the product")
	public String saveProduct(@ModelAttribute("product")ProductDTO product,RedirectAttributes redicrectAttributes,
			                                                   Model model) {
		 ProductDTO registerProduct = productService.registerProduct(product);
		 redicrectAttributes.addFlashAttribute("msg", "product register sucessfully: "+registerProduct.getId());
		return "redirect:/list_product";
	}
	
	@GetMapping(value = "/list_product")
	public String getListOfProduct(Model model,HttpSession session,HttpServletRequest req,RedirectAttributes redicrectAttributes) {
		String  user = (String) session.getAttribute("user");
		
		HttpSession session2 = req.getSession();
		System.out.println(session2);
		
		if(user!=null) {
			List<ProductDTO> allProduct = productService.fetchAllProduct();
			model.addAttribute("listProduct", allProduct);
			return "listproduct";
		}else {
			redicrectAttributes.addFlashAttribute("msg", "InValid Session please try to login one more time");
			return "redirect:/";
		}
		
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteProduct(@PathVariable("id")Long id,HttpSession session,RedirectAttributes redicrectAttributes) {
		String  user = (String) session.getAttribute("user");
		if(user!=null) {
		productService.deleteProduct(id);
		 redicrectAttributes.addFlashAttribute("msg", "product deleted sucessfully: "+id);
		return "redirect:/list_product";
		}else {
			redicrectAttributes.addFlashAttribute("msg", "InValid Session please try to login one more time");
			return "redirect:/";
		}
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editProduct(@PathVariable("id")Long id,Model model,HttpSession session,RedirectAttributes redicrectAttributes) {
		String  user = (String) session.getAttribute("user");
		if(user!=null) {
			ProductDTO productById = productService.fetchProductById(id);
			
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
			sd.format(new Date());
			productById.setMfd(sd);
			model.addAttribute("product", productById);
			model.addAttribute("type", ProductType.values());
			return "edit";
		}else {
			redicrectAttributes.addFlashAttribute("msg", "InValid Session please try to login one more time");
			return "redirect:/";
		}
	
	}
	
	@PostMapping(value  = "/update")
	public String updateProduct(@ModelAttribute("product")ProductDTO product,Model model,HttpSession session,RedirectAttributes redicrectAttributes) {
		String  user = (String) session.getAttribute("user");
		if(user!=null) {
		productService.updateProduct(product);
		 redicrectAttributes.addFlashAttribute("msg", "product updated sucessfully: "+product.getId());
		return "redirect:/list_product";
		}else {
			redicrectAttributes.addFlashAttribute("msg", "InValid Session please try to login one more time");
			return "redirect:/";
		}
	}
	
	@GetMapping(value = "/logout")
	public String logut(HttpSession session,RedirectAttributes ra) {
		String user = (String) session.getAttribute("user");
		if(user!=null) {
			session.removeAttribute("user"); //remove particular attributes
			session.invalidate();       //invalidate the session
			
		ra.addFlashAttribute("msg", "User Logged Out");
		return "redirect:/";
		}else {
			return "redirect:/";
		}
	}
	
	//HERE you can write exception handling logic
	
	

	
	
	
	
	
	
	
	
	
	
	
}
