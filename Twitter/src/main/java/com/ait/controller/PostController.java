package com.ait.controller;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ait.bean.LoginUser;
import com.ait.bean.PostBean;
import com.ait.bean.PostWithSentimentDTO;
import com.ait.model.PostEntity;
import com.ait.service.PostService;
import com.ait.service.UserService;
import com.ait.util.YoutubeMotivationalVideo;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostController {
	@Autowired
	PostService postService;
	@Autowired
	UserService userservice;
	@Autowired
	YoutubeMotivationalVideo youtubeMotivationalVideo;

	@PostMapping("/posttweet")
	public String loginUser(@ModelAttribute("postcontent") PostBean postbean,
			Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		String username = (String) session.getAttribute("username");
		if (username != null) {

			postbean.setTime(LocalDateTime.now());
			postbean.setUsername(username);
			try {
				List<PostEntity> post = postService.createPost(postbean);
			} catch (Exception e) {
				  redirectAttributes.addFlashAttribute("errorMessage",
						  e.getLocalizedMessage().split("\\.")[0]);
				return "redirect:/postpage";
			}
			return "redirect:/postpage";
		} else {
			redirectAttributes.addFlashAttribute("msg", "Session is expired try to login..!!!");
			return "redirect:/login";
		}
	}

	@GetMapping("/postpage")
	public ModelAndView getPostPage(Model model, HttpSession session,RedirectAttributes redirectAttributes) {
		String username = (String) session.getAttribute("username");
		ModelAndView mav = new ModelAndView();
		if (username != null) {

			PostBean postBean = new PostBean();

			mav.addObject("postcontent", postBean);
			List<PostWithSentimentDTO> post = postService.getPost(username);
			post.forEach(data -> {
				postBean.setUsername(data.getPost().getUsername());

			});
			
			byte[]  profilepic = (byte[]) session.getAttribute("profilepic");
			// Convert to base64 string
			String base64Image = Base64.getEncoder().encodeToString(profilepic);
			// Build image src with Base64 data URI
			String base64ImageSrc = "data:image/jpeg;base64," + base64Image;
			mav.addObject("posts", post);
			mav.addObject("profilePicSrc", base64ImageSrc);
			mav.setViewName("homepage");
			return mav;
		} else {
			redirectAttributes.addFlashAttribute("msg", "Session is expired try to login..!!!");
			mav.addObject("user", new LoginUser());
			mav.setViewName("login");
			return mav;
		}
	}

	@GetMapping("/post/delete/{id}")
	public String deletePost(@PathVariable("id") int id, HttpSession session,RedirectAttributes redirectAttributes) {
		String username = (String) session.getAttribute("username");
		if (username != null) {
			postService.deletePostById(id);
			redirectAttributes.addFlashAttribute("errorMessage", "post deleted succesfully..!!!");
			return "redirect:/postpage";
		} else {
			redirectAttributes.addFlashAttribute("msg", "Session is expired try to login..!!!");
			return "redirect:/login";
		}
	}

	@GetMapping("/motivation")
	public ModelAndView motivationLibrary(HttpSession session,RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			List<String> video = youtubeMotivationalVideo.getVideo();
			mav.addObject("video", video);
			mav.setViewName("video-lib");
			return mav;
		} else {
			redirectAttributes.addFlashAttribute("msg", "Session is expired try to login..!!!");
			mav.addObject("user", new LoginUser());
			mav.setViewName("login");
			return mav;
		}

	}
}
