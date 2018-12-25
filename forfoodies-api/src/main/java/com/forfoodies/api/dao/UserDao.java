package com.forfoodies.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.forfoodies.api.models.User;
import com.forfoodies.api.repositories.UserRepository;

@Component
public class UserDao {

	private UserRepository userRepository;

	@Autowired
	public UserDao(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Integer insertUserToUsers(String email, String password, String name) {
		this.userRepository.insertUserToUsers(email, password, name);
		return getUserByEmail(email).getId();
	}

	public Integer getUserIdByToken(String token) {
		return this.userRepository.getUserIdByToken(token);
	}

	public User getUserByEmail(String email) {
		return this.userRepository.getUserByEmail(email);
	}

}
