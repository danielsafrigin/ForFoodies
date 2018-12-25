package com.forfoodies.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forfoodies.api.components.RoleComponent;
import com.forfoodies.api.components.SessionComponent;
import com.forfoodies.api.dao.PostDao;
import com.forfoodies.api.dao.UserDao;

@Service
public class PostService {

	private SessionComponent sessionComponent;
	private RoleComponent roleComponent;
	private UserDao userDao;
	private PostDao postDao;

	@Autowired
	public PostService(UserDao userDao, RoleComponent roleComponent, SessionComponent sessionComponent,
			PostDao postDao) {
		this.userDao = userDao;
		this.roleComponent = roleComponent;
		this.sessionComponent = sessionComponent;
		this.postDao = postDao;
	}

	public void createPost(String token, String body) {
		System.out.println(1);
		if (this.sessionComponent.isTokenValid(token)) {
			System.out.println(2);
			if (this.roleComponent.hasPermission(token, 1)) {
				System.out.println(3);
				Integer userId = this.userDao.getUserIdByToken(token);
				this.postDao.insertPostToPosts(body, userId);
			}
		}
	}
}
