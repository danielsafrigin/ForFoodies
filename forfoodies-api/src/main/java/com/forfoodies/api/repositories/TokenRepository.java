package com.forfoodies.api.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.forfoodies.api.models.Token;

public interface TokenRepository extends CrudRepository<Token, Integer>{

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user_token(token, user_id, time_stamp) VALUES (?,?, CURRENT_TIMESTAMP)", nativeQuery = true)
	void instertTokenToTokens(String token, int userId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user_token SET token = ?1 WHERE id = ?2", nativeQuery = true)
	void updateUserToken(String token, int userId);
	
	@Query(value = "SELECT TIME_TO_SEC(TIMEDIFF(CURRENT_TIMESTAMP, time_stamp)) FROM user_token WHERE token = ?1", nativeQuery = true)
	Integer tokenTimePassedInSeconds(String token);

	@Modifying
	@Transactional
	@Query(value = "UPDATE user_token SET time_stamp = CURRENT_TIMESTAMP WHERE id = ?1", nativeQuery = true)
	void updateUserTimeStamp(int userId);
}
