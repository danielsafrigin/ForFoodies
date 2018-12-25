package com.forfoodies.api.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forfoodies.api.services.UserService;

@RestController
public class ConnectionController {

	private UserService userService;

	@Autowired
	public ConnectionController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public String registerUser(@RequestParam Map<String, String> body) {
		System.out.println(body.get("email") + body.get("password") + body.get("name"));
		return this.userService.register(body.get("email"), body.get("password"), body.get("name"));
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam Map<String, String> body) {
		return this.userService.login(body.get("email"), body.get("password"));
	}

}
