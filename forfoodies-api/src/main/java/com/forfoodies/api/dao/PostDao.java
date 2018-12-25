package com.forfoodies.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.forfoodies.api.models.Post;
import com.forfoodies.api.repositories.PostRepository;

@Component
public class PostDao {

	private PostRepository postRepository;

	@Autowired
	public PostDao(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public Post getPost(int postId) {
		return this.postRepository.getPost(postId);
	}

	public List<Post> getAllPosts() {
		return this.postRepository.getAllPosts();
	}

	public void insertPostToPosts(String body, int userId) {
		this.postRepository.insertPostToPosts(body, userId);
	}

}
