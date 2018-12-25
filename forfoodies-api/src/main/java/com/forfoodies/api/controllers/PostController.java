package com.forfoodies.api.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.forfoodies.api.services.PostService;

@RestController
public class PostController {

	
	private PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@PostMapping("/createPost")
	public String createPost(@RequestParam Map<String, String> body, @RequestHeader(value = "token") String token) {
		this.postService.createPost(token, body.get("body"));
		return null;
	}
	
	@PostMapping("/deleteMyPost")
	public String deleteMyPost(@RequestParam Map<String, String> body, @RequestHeader(value = "token") String token) {
		//TODO
		return null;
	}
	
	@PostMapping("/deleteAnyPost")
	public String deleteAnyPost(@RequestParam Map<String, String> body, @RequestHeader(value = "token") String token) {
		//TODO
		return null;
	}
	
	@PostMapping("/getAllPosts")
	public String getAllPosts(@RequestParam Map<String, String> body, @RequestHeader(value = "token") String token) {
		//TODO
		return null;
	}
	

}
