package com.zensar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/all")
	public String sayHello() {
		return "<h1> Hello </h1>";
	}
	
	@GetMapping("/admin")
	public String sayHelloAdmin() {
		return "<h1> Admin </h1>";
	}
	
	@GetMapping("/user")
	public String sayHelloUser() {
		return "<h1> user </h1>";
	}
}
