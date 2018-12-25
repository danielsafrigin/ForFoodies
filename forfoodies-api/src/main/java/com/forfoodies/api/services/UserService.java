package com.forfoodies.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forfoodies.api.components.RoleComponent;
import com.forfoodies.api.components.SessionComponent;
import com.forfoodies.api.dao.UserDao;
import com.forfoodies.api.models.User;
import com.forfoodies.authentication.AuthToken;

@Service
public class UserService {

	private UserDao userDao;
	private RoleComponent roleComponent;
	private SessionComponent sessionComponent;

	@Autowired
	public UserService(UserDao userDao, RoleComponent roleComponent, SessionComponent sessionComponent) {
		this.userDao = userDao;
		this.roleComponent = roleComponent;
		this.sessionComponent = sessionComponent;
	}

	public String register(String email, String password, String name) {
		if (!isUserExist(email)) {
			int userId = this.userDao.insertUserToUsers(email, password, name);
			String token = AuthToken.generateToken();
			this.sessionComponent.instertTokenToTokens(token, userId);
			this.roleComponent.insertRoleToUserHasRole(userId, 2);
			return token;
		}
		return null;
	}

	public String login(String email, String password) {
		if (isUserExist(email) && isCorrectPassword(email, password)) {
			int userId = this.userDao.getUserByEmail(email).getId();
			String token = AuthToken.generateToken();
			this.sessionComponent.updateUserToken(token, userId);
			return token;
		}
		return null;
	}

	public boolean isCorrectPassword(String email, String password) {
		if (getUserByEmail(email).getPassword().equals(password)) {
			return true;
		} else
			return false;
	}

	public boolean isUserExist(String email) {
		if (getUserByEmail(email) == null) {
			return false;
		} else
			return true;
	}

	public Integer getUserByToken(String token) {
		return this.userDao.getUserIdByToken(token);
	}

	public User getUserByEmail(String email) {
		return this.userDao.getUserByEmail(email);
	}
}