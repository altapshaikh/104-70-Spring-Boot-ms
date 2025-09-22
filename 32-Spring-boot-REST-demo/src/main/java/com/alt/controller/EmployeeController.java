package com.alt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alt.beans.EmployeeDTO;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController { // controller or //resource

	@GetMapping
	@ResponseBody
	public String getEmployee() {
		return null;

	}

	// name and city
	@GetMapping(value = "/search")
	public String searchEmployee(@RequestParam String name,
			@RequestParam(name = "city", required = false) String city) {
		return city;

	}
	// http://<host>:<port>/api/search?name="raja"&city="hyd"

	// name
	@GetMapping(value = "/search/{name}/{city}")
	public String searchEmployee1(@PathVariable(name = "name") String name, @PathVariable String city) {
		return city;

	}

	// http://<host>:<port>/api/search/raja/hyd

	@PostMapping
	public String registerEmployee(@RequestBody EmployeeDTO employee) {
		return null;
		// service---->method--->db
	}

}
