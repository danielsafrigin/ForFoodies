package com.forfoodies.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.forfoodies.api.models.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user(email, password, name) VALUES (?, ?, ?)", nativeQuery = true)
	void insertUserToUsers(String email, String password, String name);

	@Query(value = "SELECT * FROM user WHERE email = ?1", nativeQuery = true)
	User getUserByEmail(String email);

	@Query(value = "SELECT user_id FROM user_token WHERE token = ?1", nativeQuery = true)
	Integer getUserIdByToken(String token);

}