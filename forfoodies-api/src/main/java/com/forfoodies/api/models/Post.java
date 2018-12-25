package com.forfoodies.api.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "user_post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private int userId;
	private String body;

	public Post() {

	}

	public Post(String body) {
		this.body = body;
	}

	public Post(int id, String body, int userId) {
		this.id = id;
		this.body = body;
		this.userId = userId;
	}

	public String getBody() {
		return body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [body=" + body + "]";
	}

}
