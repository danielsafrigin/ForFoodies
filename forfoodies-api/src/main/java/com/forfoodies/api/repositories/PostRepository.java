package com.forfoodies.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.forfoodies.api.models.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

	@Query(value = "SELECT * FROM user_post WHERE id = ?1", nativeQuery = true)
	Post getPost(int postId);

	@Query(value = "SELECT * FROM user_post", nativeQuery = true)
	List<Post> getAllPosts();

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user_post(body, user_id) VALUES (?,?)", nativeQuery = true)
	void insertPostToPosts(String body, int userId);
}
