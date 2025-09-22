package com.alt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
@GetMapping(value = "/msg")
	public String msg() {
		return "welcome";
	}
}
