package com.forfoodies.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.forfoodies.api.repositories.TokenRepository;

@Component
public class SessionDao {

	private TokenRepository tokenRepository;

	@Autowired
	public SessionDao(TokenRepository tokenRepository) {
		this.tokenRepository = tokenRepository;
	}

	public void instertTokenToTokens(String token, int userId) {
		this.tokenRepository.instertTokenToTokens(token, userId);
	}

	public void updateUserToken(String token, int userId) {
		this.tokenRepository.updateUserToken(token, userId);
	}

	public Integer tokenTimePassedInSeconds(String token) {
		return this.tokenRepository.tokenTimePassedInSeconds(token);
	}

	public void updateUserTimeStamp(int userId) {
		this.tokenRepository.updateUserTimeStamp(userId);
	}

}
