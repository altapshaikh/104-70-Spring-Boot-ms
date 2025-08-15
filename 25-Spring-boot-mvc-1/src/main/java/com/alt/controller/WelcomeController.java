package com.alt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/welcome")  //controller mapping
public class WelcomeController {

	@GetMapping("/wish")    //request method mapping
	public String welcome() {
		return "index";  //logical view name
	}
	
	@GetMapping("/greet")    //request method mapping
	public String welcomeMsg(Model model) {
		model.addAttribute("msg", "welcome to Spring boot mvc");
		return "greeting";  //logical view name
	}
}
