package com.forfoodies.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/hello2")
	public String RespondHi() {
		return "hello";
	}

}
