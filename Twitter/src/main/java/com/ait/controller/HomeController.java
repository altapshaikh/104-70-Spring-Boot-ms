package com.ait.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ait.bean.LoginUser;
import com.ait.bean.PostBean;
import com.ait.bean.UserBean;
import com.ait.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;

	@GetMapping
	public String getHomePage() {
		return "index";
	}

	@GetMapping(value = "/register")
	public String register(Model model) {
		model.addAttribute("user", new UserBean());
		return "registration";
	}

	@PostMapping("/register")
	public String processRegistration(@ModelAttribute("user") UserBean user,
			@RequestParam("profilePic") MultipartFile profilePic, RedirectAttributes redirectAttributes ) throws IOException {
		UserBean registerUser = userService.registerUser(user,profilePic);
		redirectAttributes.addFlashAttribute("msg", "User registered successfulyy....!!!");
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new LoginUser());
		return "login";
	}
	@GetMapping("/about")
	public String about(Model model) {
	
		return "about";
	}
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("user") LoginUser user, HttpSession session, 
			Model model,RedirectAttributes redirectAttributes) {
		boolean loginUser = userService.loginUser(user,session);
		if (loginUser) {
			PostBean postBean = new PostBean();
			postBean.setUsername(user.getEmail());
			// handled session

			handleSession(user.getEmail(), session);
			model.addAttribute("postcontent", postBean);
			return "redirect:/postpage";
		} else {
			redirectAttributes.addFlashAttribute("msg", "username and password not match..!!!");
			return "redirect:/login";
		}

	}

	@GetMapping("/edit/{email}")
	public String showUpdateForm(@PathVariable String email, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) {
		String username = (String) session.getAttribute("username");
		if (username != null) {
			UserBean updateUser = userService.updateUser(email);
			model.addAttribute("user", updateUser);
			return "update-user";
		} else {
			redirectAttributes.addFlashAttribute("msg", "Session is expired try to login..!!!");
			return "redirect:/login";
		}

	}
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("user") UserBean user, HttpSession session,
			RedirectAttributes redirectAttributes) {
		String username = (String) session.getAttribute("username");
		if (username != null) {
			userService.updateUser(user);
			redirectAttributes.addFlashAttribute("msg", "User updated successfulyy....!!!");
			return "redirect:/login";
		} else {
			redirectAttributes.addFlashAttribute("msg", "Session is expired try to login..!!!");
			return "redirect:/login";
		}

	}

	@GetMapping("/delete/{email}")
	public String deleteAccount(@PathVariable String email, HttpSession session,RedirectAttributes redirectAttributes) {
		String username = (String) session.getAttribute("username");
		if (username != null) {
			userService.deleteUser(email);
			redirectAttributes.addFlashAttribute("msg", "user deleted sucessfully..!!!");
			return "redirect:/login";
		} else {
			redirectAttributes.addFlashAttribute("msg", "Session is expired try to login..!!!");
			return "redirect:/login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session,Model model) {
		handleLogout(session);
		return "redirect:/login";
	}
	public void handleSession(String username, HttpSession session) {
		session.setAttribute("username", username);
		session.setMaxInactiveInterval(300);
	}

	public void handleLogout(HttpSession session) {
		session.removeAttribute("username");
		session.invalidate();
	}
}
