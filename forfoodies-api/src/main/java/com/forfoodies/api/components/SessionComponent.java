package com.forfoodies.api.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.forfoodies.api.dao.SessionDao;
import com.forfoodies.api.dao.UserDao;

@Component
public class SessionComponent {

	private UserDao userDao;
	private SessionDao sessionDao;

	@Autowired
	public SessionComponent(SessionDao sessionDao, UserDao userDao) {
		this.sessionDao = sessionDao;
		this.userDao = userDao;
		
	}

	public boolean isTokenValid(String token) {
		if (this.userDao.getUserIdByToken(token) != null) {
			int timePassedInSeconds = this.sessionDao.tokenTimePassedInSeconds(token);
			int maxTimePassedInSeconds = 86400;
			if (timePassedInSeconds < maxTimePassedInSeconds) {
				return true;
			}
			else System.out.println(timePassedInSeconds +">"+ maxTimePassedInSeconds);
		}
		return false;
	}
	public Integer tokenTimePassedInSeconds(String token) {
		return this.sessionDao.tokenTimePassedInSeconds(token);
	}
	
	public void updateUserToken(String token, int userId) {
		this.sessionDao.updateUserToken(token, userId);
		this.sessionDao.updateUserTimeStamp(userId);
	}
	
	public void instertTokenToTokens(String token, int userId) {
		this.sessionDao.instertTokenToTokens(token, userId);
	}
}
