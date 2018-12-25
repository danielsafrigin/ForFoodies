package com.forfoodies.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.forfoodies.api.components.RoleComponent;
import com.forfoodies.api.components.SessionComponent;
import com.forfoodies.api.dao.PostDao;
import com.forfoodies.api.dao.UserDao;
import com.forfoodies.api.services.PostService;
import com.forfoodies.api.services.UserService;

@SpringBootApplication
public class ForFoodiesAPI {

	
	public static void main(String[] args) {
		SpringApplication.run(ForFoodiesAPI.class, args);

	}
	
}
